package br.com.fiap.ads.ddd.nac.model;

import java.io.Serializable;


/**
 * Classe que representa um veículo
 * 
 * @author Fabio Sobottka
 *
 */
@SuppressWarnings("serial")
public class Veiculo implements Serializable {
	
	private int id;
	private String modelo;
	private String placa;
	private String ano;
	private double motor;
	
	
	public Veiculo() {
		
	}
	
	/**
	 * @param modelo
	 * @param placa
	 * @param ano
	 * @param motor
	 */
	public Veiculo(String modelo, String placa, String ano, double motor) {
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
		this.motor = motor;
	}



	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getModelo() {
		return modelo;
	}
	
	
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
	public String getPlaca() {
		return placa;
	}
	
	
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	public String getAno() {
		return ano;
	}
	
	
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	public double getMotor() {
		return motor;
	}
	
	
	public void setMotor(double motor) {
		this.motor = motor;
	}
	
	
	
} 
