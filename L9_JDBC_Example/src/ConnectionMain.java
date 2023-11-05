import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Reflection API to load the class dynamically
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","password");
			
			System.out.println("Database connection Success"+con);
			
			Statement stm = con.createStatement();
			
			String query = "CREATE DATABASE IF NOT EXISTS jbdl60";
			
			System.out.println(stm.execute(query));
			
			System.out.println("Schema created successfully.");
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
