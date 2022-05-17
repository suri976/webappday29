package ai.jobiak.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FactorialServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "factorial:";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=res.getWriter();
		int f=1;
		for(int i=1;i<=5;i++)
		{
			f=f*i;
		}
		out.println("the factorila of 5 is" + f);
		
		
		HashMap<String ,String> techinventers= new HashMap();
		techinventers.put("java","james gosling");
		techinventers.put("Python","james gosling");
		techinventers.put("cpp","james gosling");
		techinventers.put("c","james gosling");
		techinventers.put("java","james gosling");
		
		out.println(techinventers);
		
		Set<String>keys= techinventers.keySet();
		for(String key:keys)
		{
			out.println(techinventers.get(key)+" and length is "+ techinventers.get(key).length());
		}
		
		
		
	}

}
