/**
 * 
 */
package br.com.fiap.ads.ddd.nac.exceptions;

/**
 * Exception que representa o erro que ocorre quando a placa está fora do padrão brasileiro
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class PlacaForaDoPadraoException extends Exception {
	
	public PlacaForaDoPadraoException() {
		
		super("Ops - algo inesperado ocorreu. Placa fora do padrão brasileiro");
	
	}
	
}
