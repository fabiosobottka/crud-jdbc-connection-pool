package br.com.fiap.ads.ddd.nac.exceptions;

/**
 * Exception que representa o erro que ocorre quando o ano do ve�culo est� incorreto.
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class AnoVeiculoException extends Exception {
	
	public AnoVeiculoException() {
		
		super("Ops - Algo inesperado ocorreu. Ano de fabrica��o do ve�culo incorreto");
		
	}

}
