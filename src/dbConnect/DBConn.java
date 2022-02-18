package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=PlantToxicity;";
	static final String USER = "user=sa;";
	static final String PASS = "password=password";

	//public static void main (String[] args) throws SQLException {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=PlantToxicity;user=sa;password=password";
			
		System.out.println("Connecting to the Plant Toxicity database...");
		
		// Open Connection & get driver
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(connectionUrl);
		
		System.out.println("Connected database successfully!\n");
		
		return con;

	}

}