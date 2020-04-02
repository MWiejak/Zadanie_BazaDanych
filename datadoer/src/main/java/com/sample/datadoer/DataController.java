package com.sample.datadoer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataController {
	
	public void getCustomers() {
		Connection conn=null;
		String db = "jdbc:hsqldb:hsql://localhost/sampledb;ifexists=true;";
		String user="SA";
		String password="";
		try {
			conn=DriverManager.getConnection(db,user,password);
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT FIRSTNAME, LASTNAME FROM CUSTOMER");
			while(rs.next()) {
				System.out.println("Customer Name: " + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME"));			
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			
		}
		finally {
			try {
				if (conn !=null)
					conn.close();
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}

}
}