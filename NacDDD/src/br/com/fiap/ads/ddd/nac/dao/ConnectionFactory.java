package br.com.fiap.ads.ddd.nac.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



/**
 * Classe respons�vel por gerenciar o pull de conex�es
 * 
 * @author Fabio Sobottka
 *
 */
public class ConnectionFactory {
	
	// inst�ncia �nica
	private static ConnectionFactory connectionFactory;
	
	private DataSource dataSource;
	
	private ConnectionFactory() throws NamingException {
		
		// Cria o DataSource
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		dataSource = (DataSource) envContext.lookup("jdbc/dataSourcePool");
		
		

	}
	
	public static ConnectionFactory getInstance() throws SQLException {
		
		try {
			
			if(connectionFactory == null) {
				connectionFactory = new ConnectionFactory();
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
			
			throw new SQLException("O data source n�o foi encontrado");
		}
		
		return connectionFactory;
		
	}
	
	public Connection getConnection() throws SQLException {
		try {
			
			return dataSource.getConnection();
			
		} catch (SQLException e) {
			
			throw new SQLException("Erro ao obter uma conex�o com o banco de dados", e);
		}
	}

}
