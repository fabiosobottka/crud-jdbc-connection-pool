package br.com.fiap.ads.ddd.nac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.ads.ddd.nac.bo.VeiculoBO;
import br.com.fiap.ads.ddd.nac.model.Veiculo;

/**
 * Controller do Cadastro de Veiculos
 * 
 * @author Fabio Sobottka
 */
@WebServlet("/cadastro-veiculo")
public class CadastroVeiculoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			VeiculoBO veiculoBO = new VeiculoBO();
			List<Veiculo> veiculos = veiculoBO.listarVeiculos();

			request.setAttribute("listaVeiculos", veiculos);

		} catch (SQLException e) {
			e.printStackTrace();

			redireciona(request, response, "erro.jsp", e.getMessage());
		}

		redireciona(request, response, "veiculos.jsp", null);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("option").equals("incluirVeiculo")) {

			incluirVeiculo(request, response);

		}

		else if (request.getParameter("option").equals("excluirVeiculo")) {

			excluirVeiculo(request, response);

		}

		else if (request.getParameter("option").equals("alterarVeiculo")) {

			alterarVeiculo(request, response);

		} else if (request.getParameter("option").equals("exportarVeiculos")) {

			exportarVeiculosNovos(request, response);

		}

	}

	private void incluirVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Pega os valor de Input da interface
		String modelo = request.getParameter("iModelo");
		String placa = request.getParameter("iPlaca");
		String ano = request.getParameter("iAno");
		String motorTmp = request.getParameter("iMotor");
		double motor = 0.0;
		
		if(!(motorTmp.equals(""))) {
			
			motor = Double.parseDouble(motorTmp);
			
		} else
			redireciona(request, response, "erro.jsp", "Não foi preenchendo o campo motor");
		
		
		Veiculo veiculo = new Veiculo(modelo, placa, ano, motor);

		// Inseri o aluno
		VeiculoBO veiculoBO = new VeiculoBO();

		try {

			veiculoBO.inserirVeiculo(veiculo);

		} catch (Exception e) {
			e.printStackTrace();

			redireciona(request, response, "erro.jsp", e.getMessage());
		}

		doGet(request, response);

	}

	private void excluirVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Veiculo veiculo = new Veiculo();
		
		String placa = request.getParameter("iPlaca");
		
		veiculo.setPlaca(placa);
		
		VeiculoBO veiculoBO = new VeiculoBO();
		
		try {
			
			veiculoBO.excluirVeiculo(veiculo);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			redireciona(request, response, "erro.jsp", e.getMessage());
		}
		
		doGet(request, response);

	}

	private void alterarVeiculo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Veiculo veiculo = new Veiculo();

		String placaAtual = request.getParameter("iPlacaAtual");
		veiculo.setPlaca(placaAtual);

		String placaNova = request.getParameter("iPlacaNova");

		VeiculoBO veiculoBO = new VeiculoBO();

		try {

			veiculoBO.alterarVeiculo(veiculo, placaNova);

		} catch (Exception e) {
			e.printStackTrace();

			redireciona(request, response, "erro.jsp", e.getMessage());
		}

		doGet(request, response);

	}
	
	private void exportarVeiculosNovos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VeiculoBO veiculoBO = new VeiculoBO();
		
		try {
			
			veiculoBO.exportarVeiculosAno();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			redireciona(request, response, "erro.jsp", e.getMessage());
		}
		
		doGet(request, response);
		
	}

	private void redireciona(HttpServletRequest request, HttpServletResponse response, String destino, String mensagem) throws ServletException, IOException {

		//
		// mensagem para o usuario sobre o resultado da operacao
		//
		request.setAttribute("mensagem", mensagem);

		//
		// redireciona para a view correta (cadastro ou erro, neste caso)
		//
		request.getRequestDispatcher(destino).forward(request, response);

	}

}
