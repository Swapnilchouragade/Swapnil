package com.pooling;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

/**
 * Servlet implementation class PoolingServlet
 */
@WebServlet("/PoolingServlet")
public class PoolingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(1111111);
		int sid=0;
		String sname=null;
		try
		{
		Properties p=new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY, "tomcat.jndi.InitialContextFactory");
			p.put(Context.PROVIDER_URL, "t3:localhost:3306");
			Context ctx = null;
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			System.out.println("inside try");
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/test");
			System.out.println("inside 1");
		    con = ds.getConnection();
			stmt = con.createStatement();
				
				rs = stmt.executeQuery("select * from login");
				System.out.println(rs);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
