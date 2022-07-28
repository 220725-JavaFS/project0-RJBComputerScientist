package banking;

import java.sql.DriverManager;

public class connection {
	static connection con;
	public static connection getConnection() {
		try {
			String mysqlJDBCDriver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/Bank"; //path to my local database
			String user = "root"; // generally sensitive information
			String password = "123"; // generally sensitive information
			Class.forName(mysqlJDBCDriver);
			con = (connection) DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			System.out.println("Connection Failed With: "+e.toString());
		}
		return con;
	}
}
