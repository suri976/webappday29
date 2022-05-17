package ai.jobiak.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcConfigServlet
 */
@WebServlet(
		urlPatterns = { "/jdbcconfigservlet" }, 
		initParams = { 
				@WebInitParam(name = "user name", value = "root", description = "usernam for db"), 
				@WebInitParam(name = "password", value = "admin", description = "db password"), 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/world", description = "mysql connector url")
		})
public class JdbcConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcConfigServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//servlet config implementation by creating its object
		// config data(init parameters)is not sharable and available to one servlet
		
		PrintWriter out =response.getWriter().append("Served at: ").append(request.getContextPath());
	    ServletConfig config = getServletConfig();
	    String url = config.getInitParameter("url");
	    String username = config.getInitParameter("username");
	    String password = config.getInitParameter("password");
	    out.println(url+username+password);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
