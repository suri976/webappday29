package ai.jobiak.state;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterCookieServlet
 */
@WebServlet(description = "about cookie", urlPatterns = { "/counterCookie" })
public class CounterCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		int count=1,beg=0;
		if(beg==0)
		{
		Cookie counterCookie=new Cookie("visits",count+"");
		response.addCookie(counterCookie);
		//out.println("count ="+count);
		beg++;
		}
		Cookie cookies[]=request.getCookies();
		//int cookieCounter=0;
		if(cookies!=null) {
			System.out.println(cookies[0]);
		for(int i=0;i<cookies.length;i++)
		{
			if(cookies[i].getName().equals("visits"))
			{
			int cookieCounter=Integer.parseInt(cookies[i].getValue());
			System.out.println(cookieCounter);
			count=	++cookieCounter;
			}
		}
		Cookie counterCookie=new Cookie("visits",count+"");
		response.setContentType("text/html");
		response.addCookie(counterCookie);
		
		out.println("<h2>"+count+"</h2>");
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
