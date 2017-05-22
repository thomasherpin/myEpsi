package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTool {
	public static void main(String[] args){
		Connection con = ConnectionTool.getConnection();
		if (con != null){
			System.out.println(con.toString());
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {

		System.out.println("hey1");
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA","");
			System.out.println("connectiondone");
			return con;
		} catch (ClassNotFoundException e) {
			System.out.println("heyclass");
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			System.out.println("heysql");
			e.printStackTrace();
			return null;
		}
	}
	
}
