package com.ai.jdbc.attributes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseData
 */
@WebServlet(description = "main data in this servlet", urlPatterns = { "/basedata" })
public class BaseData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = connect();
		int count = 0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");
			rs.next();			
			
			
			PrintWriter out =response.getWriter();
			
			ServletContext context = getServletContext();
			context.setAttribute("id", rs.getString(1));
			context.setAttribute("title", rs.getString(2));
			context.setAttribute("balance", rs.getString(3));
			
			
			RequestDispatcher dispatcher =   context.getRequestDispatcher("/requiredata");
			dispatcher.forward(request, response);
			//context.setAttribute("dbVersion", "8.0.28");
			
			
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection connect()
    {
    	String url="jdbc:mysql://localhost:3306/world";
		String uname="root";
		String pass="Password@123";
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Connection con;
		Connection con = null;
		try {
			con = DriverManager.getConnection(  
					url,uname,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
				return con;
    }
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
