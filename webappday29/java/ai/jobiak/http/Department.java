package ai.jobiak.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Department
 */
@WebServlet("/department")
public class Department extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Connection con = connect();
		int count = 0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from signup");
			
			
			
			
			PrintWriter out = response.getWriter();
			out.println();
			while(rs.next())
			{
				out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
			}
			
			
			
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
//		Connection con = connect();
//		int count = 0;
//		try {
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("select * from dept");
//			
//			
//			
//			PrintWriter out = response.getWriter();
//			while(rs.next())
//			{
//				out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
//			}
//			
//			
//			
//		}
//		catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
		
		
		
	}

}
