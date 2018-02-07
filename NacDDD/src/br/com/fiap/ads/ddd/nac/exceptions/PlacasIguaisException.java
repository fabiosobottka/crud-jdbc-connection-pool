package br.com.fiap.ads.ddd.nac.exceptions;

/**
 * Exception que representa o erro que ocorre quando a placa atual do veiculo e a placa nova a ser alterada s�o iguais
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class PlacasIguaisException extends Exception {
	
	public PlacasIguaisException() {
		
		super("Ops - algo inesperado ocorreu. O valor dar placa que deseja atualizar � o mesmo da placa atual.");
		
	}
	
	
}
