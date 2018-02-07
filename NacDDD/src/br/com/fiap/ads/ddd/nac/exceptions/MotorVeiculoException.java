package br.com.fiap.ads.ddd.nac.exceptions;

/**
 * Exception que representa o erro que ocorre quando os dados do motor estão incorretos
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class MotorVeiculoException extends Exception {
	
	public MotorVeiculoException() {
		super("Ops - Algo inesperado ocorreu. Dados do motor do veículo incorreto");
	}
	
}
