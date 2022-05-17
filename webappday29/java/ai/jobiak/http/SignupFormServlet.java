package ai.jobiak.http;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupFormServlet
 */
@WebServlet(description = "to process html form data", urlPatterns = { "/signup" })
public class SignupFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String fnameStr = request.getParameter("fname");
      String emailStr = request.getParameter("email");
      String mobile = request.getParameter("mobile");
     response.getWriter().println(fnameStr +emailStr +mobile) ;
	
	Connection con = connect();
	int count = 0;
	try {
		PreparedStatement ps = con.prepareStatement(" insert into signup values(?,?,?)");
		ps.setString(1, fnameStr);
		ps.setString(2, emailStr);
		ps.setString(3, mobile);
		
		count = ps.executeUpdate();
		
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
	
	
	
	
	
	
}


