package br.com.fiap.ads.ddd.nac.bo;

import java.util.List;

import br.com.fiap.ads.ddd.nac.model.Veiculo;

/**
 * Interface de negocios de controle de veículos
 * 
 * @author Fabio Sobottka
 *
 */
public interface VehicleControl {
	
	public void inserirVeiculo(Veiculo veiculo) throws Exception;
	
	public void excluirVeiculo(Veiculo veiculo) throws Exception;
	
	public void alterarVeiculo(Veiculo veiculo, String placa) throws Exception;
	
	public List<Veiculo> listarVeiculos() throws Exception;
	
	public void exportarVeiculosAno() throws Exception;
	
}
