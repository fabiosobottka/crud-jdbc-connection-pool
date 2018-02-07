package br.com.fiap.ads.ddd.nac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ads.ddd.nac.model.Veiculo;

/**
 * Classe responsavel pela persistencia da entidade <code>Veiculo</code>.
 * 
 * @author Fabio Sobottka
 * 
 */
public class VeiculoDAO {

	private String msgErroConexao = "Erro na conexão com o banco de dados";
	private String msgErroFecharConexao = "Erro ao fechar a conexao com o banco de dados";

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	public VeiculoDAO() throws SQLException {

		try {

			this.connection = ConnectionFactory.getInstance().getConnection();

		} catch (SQLException e) {
			e.printStackTrace();

			throw new SQLException(msgErroConexao, e);
		}

	}

	//
	// METHODS DAO
	//

	/**
	 * Executa a SQL para inserir um veículo no banco de dados
	 * 
	 * @throws SQLException
	 */
	public void inserirVeiculo(Veiculo veiculo) throws SQLException {

		// conexão com o SGBD
		String sql = "INSERT INTO TB_VEICULO " + "(id_veiculo, modelo, placa, ano, motor)"
				+ "values (SQ_VEICULO.nextval, ?, ?, ?, ?)";

		statement = this.connection.prepareStatement(sql);
		statement.setString(1, veiculo.getModelo());
		statement.setString(2, veiculo.getPlaca());
		statement.setString(3, veiculo.getAno());
		statement.setDouble(4, veiculo.getMotor());

		statement.executeUpdate();
		statement.close();

		// verifica se a conexão está aberta
		if (this.connection != null) {

			try {
				// fecha a conexão
				this.connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

				throw new SQLException(msgErroFecharConexao, e);
			}

		}

	} // fim do método para inserir veículos

	/**
	 * Executa a SQL para excluir um veículo no banco de dados
	 * 
	 * @throws SQLException
	 */
	public void excluirVeiculo(Veiculo veiculo) throws SQLException {

		String sql = "DELETE FROM TB_VEICULO WHERE placa = ?";

		statement = this.connection.prepareStatement(sql);
		statement.setString(1, veiculo.getPlaca());
		statement.executeUpdate();

		statement.close();

		// verifica se a conexão está aberta
		if (this.connection != null) {

			try {
				// fecha a conexão
				this.connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

				throw new SQLException(msgErroFecharConexao, e);
			}

		}
	}

	/**
	 * Executa a SQL para alterar a placa de um veículo no banco de dados
	 * 
	 * @throws SQLException
	 */
	public void alterarVeiculo(Veiculo veiculo, String placa) throws SQLException {

		String SQL = "UPDATE TB_VEICULO SET placa = ?  WHERE placa = ?";

		statement = this.connection.prepareStatement(SQL);
		statement.setString(1, placa);
		statement.setString(2, veiculo.getPlaca());
		statement.executeQuery();

		statement.close();

		// verifica se a conexão está aberta
		if (this.connection != null) {

			try {
				// fecha a conexão
				this.connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

				throw new SQLException(msgErroFecharConexao, e);
			}

		}

	}

	/**
	 * Classe que lista os veiculos do bando de dados
	 * 
	 * @return lista de veiculos
	 */
	public List<Veiculo> listarVeiculos() throws SQLException {

		List<Veiculo> veiculos = new ArrayList<>();
		String sql = "SELECT * FROM TB_VEICULO ORDER BY ID_VEICULO";

		statement = this.connection.prepareStatement(sql);
		rs = statement.executeQuery();

		while (rs.next()) {

			Veiculo veiculo = new Veiculo();

			veiculo.setId(rs.getInt("id_veiculo"));
			veiculo.setModelo(rs.getString("modelo"));
			veiculo.setPlaca(rs.getString("placa"));
			veiculo.setAno(rs.getString("ano"));
			veiculo.setMotor(rs.getDouble("motor"));

			veiculos.add(veiculo);

		}

		rs.close();
		statement.close();

		// verifica se a conexão está aberta
		if (this.connection != null) {

			try {
				// fecha a conexão
				this.connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

				throw new SQLException(msgErroFecharConexao, e);
			}

		}

		return veiculos;
	} // fim do método para listarVeiculos
	
	/**
	 * Classe que lista os veiculos do bando de dados
	 * 
	 * @return lista de veiculos
	 */
	public List<Veiculo> listarVeiculosAno() throws SQLException {

		List<Veiculo> veiculos = new ArrayList<>();
		String sql = "SELECT * FROM TB_VEICULO WHERE ano = 2017 ORDER BY placa ASC, modelo ASC";

		statement = this.connection.prepareStatement(sql);
		rs = statement.executeQuery();

		while (rs.next()) {

			Veiculo veiculo = new Veiculo();

			veiculo.setModelo(rs.getString("modelo"));
			veiculo.setPlaca(rs.getString("placa"));
			veiculo.setAno(rs.getString("ano"));
			veiculo.setMotor(rs.getDouble("motor"));

			veiculos.add(veiculo);

		}

		rs.close();
		statement.close();

		// verifica se a conexão está aberta
		if (this.connection != null) {

			try {
				// fecha a conexão
				this.connection.close();

			} catch (SQLException e) {
				e.printStackTrace();

				throw new SQLException(msgErroFecharConexao, e);
			}

		}

		return veiculos;
	} // fim do método para listarVeiculos

} // fim da classe VeiculoDAO
