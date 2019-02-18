package com.alsis.shoppingcart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection utility class to get Connection objects and limit the instance of the class to one. 
 * @author RAJESH
 *
 */
public class ConnectionUtil {
	// Holds the single instance
	private static ConnectionUtil util; 
	
	//Private constructor prevents direct instantiation 
	private ConnectionUtil () throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	
	public static ConnectionUtil getUtil(){
		if (util == null){
			try {
				util = new ConnectionUtil();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} 
		return util; 
	}
	
	public Connection getConnection () {
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "root");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn; 
	}
}
