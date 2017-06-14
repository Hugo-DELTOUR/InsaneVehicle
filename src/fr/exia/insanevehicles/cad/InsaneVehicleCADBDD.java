package fr.exia.insanevehicles.cad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fr.exia.insanevehicles.model.element.IElement;

public class InsaneVehicleCADBDD implements ICAD1{
	
	private static String	URL				= "jdbc:mysql://localhost/Map?autoReconnect=true&useSSL=false";
	private static String	LOGIN			= "root";
	private static String	PASSWORD		= "";
	private Connection		connection		= null;
	private Statement		statement		= null;
		
	public Boolean open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			this.statement = this.connection.createStatement();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Verifie les Drivers");
			return false;
		} catch (final SQLException e) {
			e.printStackTrace();
			System.out.println("Verifie la connection ou tes logins");
			return false;
		}
		System.out.println("Drivers good, Connection good ");
		return true;
	}
	
	public Boolean close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public IElement[][] getCircuit(String acces) throws IOException {
		return null;
	}

	@Override
	public void saveCircuit(String cicuit, int x, int y) throws IOException {
		
	}

	@Override
	public void addCircuit(IElement[][] tableCircuit, String nomCircuit) throws IOException {
		
	}
	
	
	
}
