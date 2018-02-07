package br.com.fiap.ads.ddd.nac.exceptions;

/**
 * Exception que representa o erro que ocorre quando é ultrapassado o limite de caracteres
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class LimiteDeCaracteresException extends Exception {

	/**
	 * 
	 */
	public LimiteDeCaracteresException() {
		
		super("Ops - Algo inesperado ocorreu. O limite de caracteres foi excedido");
		
	}


}
