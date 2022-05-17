package ai.jobiak.sessionmanagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet(description = "Demonstrates http session", urlPatterns = { "/counterServlet" })
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter().append("Served at: ").append(request.getContextPath());
	    HttpSession session = request.getSession();
	    
	    
//	    HttpSession session = request.getSession();
//	    if(session !=null)
//	    {
//	    	session.invalidate();
//	    }
	    
	    int counter =1;
	    if(session.isNew())
	    {
	    	session.setAttribute("visits", counter+"");
	    	
	    }
	    else
	    {
	    	
	    	
	    	String counterStr = (String)session.getAttribute("visits");
	    	counter = Integer.parseInt(counterStr);
	    	counter++;
	    	session.setAttribute("visits", counter+"");
	    }
	
	
	response.setContentType("text/html");
	out.println("<h3> You Visited #"+ counter + "</h3>");
	  out.println(session.getCreationTime());
	  out.println("<h3> Your session id: #"+session.getId()+"</h3>");
	  out.println("<h3> Your session id: #"+session.getId()+"</h3>");
	  out.println("<h3> Your session creation time #"+session.getCreationTime()+"</h3>");
	  
	
	
	
	
	
	
	
	}

}
