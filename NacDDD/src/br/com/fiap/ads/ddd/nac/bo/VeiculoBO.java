package br.com.fiap.ads.ddd.nac.bo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.fiap.ads.ddd.nac.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.nac.exceptions.AnoVeiculoException;
import br.com.fiap.ads.ddd.nac.exceptions.LimiteDeCaracteresException;
import br.com.fiap.ads.ddd.nac.exceptions.MotorVeiculoException;
import br.com.fiap.ads.ddd.nac.exceptions.PlacaForaDoPadraoException;
import br.com.fiap.ads.ddd.nac.exceptions.PlacasIguaisException;
import br.com.fiap.ads.ddd.nac.model.Veiculo;

/**
 * Classe que contem as regras de negocio da entidade <code>Veiculo</code>.
 * 
 * @author Fabio Sobottka
 *
 */
public class VeiculoBO implements VehicleControl {
	
	// Classes do java para utiliza��o das express�es regulares
	Pattern padrao = null;
	Matcher matcher = null;

	/**
	 * Inseri um veiculo no banco de dados
	 * 
	 * @param recebe um veiculo a ser inserido no banco de dados
	 */
	@Override
	public void inserirVeiculo(Veiculo veiculo) throws Exception {

		//
		// Verifica��es do modelo
		//
		
		if(veiculo.getModelo().equals(""))
			throw new Exception("O campo da placa do ve�culo n�o foi preenchido");

		// Verifica a constraint do tamanho da string
		if (veiculo.getModelo().length() > 50)
			throw new LimiteDeCaracteresException();

		// Garante que os caracteres da string est�o em mai�sculo
		veiculo.setModelo(veiculo.getModelo().toUpperCase());

		
		//
		// Verifica��es da placa
		//
		
		if(veiculo.getPlaca().equals(""))
			throw new Exception("O campo da placa do ve�culo n�o foi preenchido");

		// Express�o regular do padr�o de placas do brasil
		padrao = Pattern.compile("[a-zA-Z][a-zA-Z][a-zA-Z]([\\s-])?\\d\\d\\d\\d");
		matcher = padrao.matcher(veiculo.getPlaca());

		// Verifica se a placa est� no padr�o brasileiro
		if (veiculo.getPlaca().length() > 8 || !matcher.matches())
			throw new PlacaForaDoPadraoException();

		// Garante que os caracteres da placa est�o em mai�sculo e retira os espa�os em branco, se houverem
		veiculo.setPlaca(veiculo.getPlaca().toUpperCase().replaceAll("([\\s-])?", ""));
		
		//
		// Verifica��es do ano do ve�culo
		//
		
		if(veiculo.getAno().equals(""))
			throw new Exception("O campo do ano do ve�culo n�o foi preenchido");

		// Padr�o do ano em n�meros
		padrao = Pattern.compile("\\d\\d\\d\\d");
		matcher = padrao.matcher(veiculo.getAno());

		if (veiculo.getAno().length() > 4 || !(matcher.matches()))
			throw new AnoVeiculoException();

		//
		// Verifica��es do motor
		//

		padrao = Pattern.compile("\\d\\.\\d");
		matcher = padrao.matcher(String.valueOf(veiculo.getMotor()));

		if (!matcher.matches())
			throw new MotorVeiculoException();

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.inserirVeiculo(veiculo);

	}

	/**
	 * exclui produtos do banco de dados
	 * 
	 * @param recebe o ve�culo a ser excluido
	 */
	@Override
	public void excluirVeiculo(Veiculo veiculo) throws Exception {
		
		if(veiculo.getPlaca().equals(""))
			throw new Exception("Ops. Voc� n�o preencheu a placa do ve�culo o qual deseja excluir");
		
		// Express�o regular do padr�o de placas do brasil
		padrao = Pattern.compile("[a-zA-Z][a-zA-Z][a-zA-Z]([\\s-])?\\d\\d\\d\\d");
		matcher = padrao.matcher(veiculo.getPlaca());

		// Verifica se a placa est� no padr�o brasileiro
		if (veiculo.getPlaca().length() > 8 || !matcher.matches())
			throw new PlacaForaDoPadraoException();
		
		// Garante que os caracteres da placa est�o em mai�sculo e retira os espa�os em branco, se houverem
		veiculo.setPlaca(veiculo.getPlaca().toUpperCase().replaceAll("([\\s-])?", ""));
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.excluirVeiculo(veiculo);

	}

	/**
	 * altera os dados do ve�culo
	 * 
	 * @param recebe o ve�culo a ser alterado
	 * @param recebe o valor da nova placa do veiculo
	 */
	@Override
	public void alterarVeiculo(Veiculo veiculo, String placa) throws Exception {
		
		if(veiculo.getPlaca().equals(""))
			throw new Exception("Ops. Voc� n�o preencheu a placa do ve�culo o qual deseja alterar");
		
		if(placa.equals(""))
			throw new Exception("Ops. Voc� n�o preencheu os dados da nova placa do ve�culo: " + veiculo.getPlaca());

		String placaAtual = veiculo.getPlaca().toUpperCase().replaceAll("([\\s-])?", "");

		if (placaAtual.equals(placa))
			throw new PlacasIguaisException();
		
		double numeroPlacaAtual = Double.parseDouble(placaAtual.substring(4, placaAtual.length()));
		System.out.println(numeroPlacaAtual);
		
		
		// Express�o regular do padr�o de placas do brasil
		padrao = Pattern.compile("[a-zA-Z][a-zA-Z][a-zA-Z]([\\s-])?\\d\\d\\d\\d");
		matcher = padrao.matcher(placaAtual);

		// Verifica se a placa est� no padr�o brasileiro
		if (veiculo.getPlaca().length() > 8 || !matcher.matches())
			throw new PlacaForaDoPadraoException();

		// Express�o regular do padr�o de placas do brasil
		matcher = padrao.matcher(placa);

		// Verifica se a placa est� no padr�o brasileiro
		if (placa.length() > 8 || !matcher.matches())
			throw new PlacaForaDoPadraoException();
		
		placa = placa.toUpperCase().replaceAll("([\\s-])?", "");
		
		double numeroPlacaNova = Double.parseDouble(placa.substring(4, placa.length()));
		System.out.println(numeroPlacaNova);
		
		// Verifica se o n�mero da placa nova � menor ou = a placa atual
		if(numeroPlacaNova <= numeroPlacaAtual)
			throw new Exception("O n�mero da placa nova deve ser maior do que o n�mero da placa atual");
		
		// Se passar pelas verifica��es, chama o veiculoDAO para cadastro no banco de dados
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.alterarVeiculo(veiculo, placa);

	}

	/**
	 * lista todos os produtos cadastrados no banco de dados
	 * 
	 * @return retorna a lista de todos os produtos cadastrados no banco de dados
	 */
	@Override
	public List<Veiculo> listarVeiculos() throws SQLException {
		

		VeiculoDAO veiculoDAO = new VeiculoDAO();

		return veiculoDAO.listarVeiculos();
	}

	/**
	 * Exporta uma lista de ve�culos do ano de 2017 para um arquivo txt
	 */
	@Override
	public void exportarVeiculosAno() throws Exception {
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		List<Veiculo> veiculosDoAno = veiculoDAO.listarVeiculosAno();
		
		String header = "ANO;PLACA;MODELO;MOTOR;\n";
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\veiculosNovos.csv"))) {
			
				writer.write(header);
				
			for(Veiculo veiculo : veiculosDoAno) {
				
				String motor = String.valueOf(veiculo.getMotor());
				
				writer.write(veiculo.getAno() + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";" + motor + ";" + "\n");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
			System.out.println("Erro na escrita do arquivo");
			throw new Exception("Erro ao exportar veiculo do ano de 2017");
		}
		
		
	}

}
