package application;
import java.sql.*;

public class Database {
	protected Connection conn;
	
	public Database(){
		
	}
	
	public Boolean login(String login, String password, String server){
		String url = "jdbc:oracle:thin:";
		// "@oracle.iut-orsay.fr:1521:etudom"
		url+= login +"/" + password + server;
		try{
			this.conn = DriverManager.getConnection(url);
			return true;
		}catch(SQLException e){
			System.out.println("error");
			return false;
		}
	}
	
	public void finalize(){
		try{
			this.conn.close();
		}catch(SQLException e){
			System.out.println("Error while closing connection");
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	
}
