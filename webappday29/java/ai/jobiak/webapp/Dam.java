package ai.jobiak.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Dam implements Servlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		PrintWriter out=arg1.getWriter();
		HashSet dams =new HashSet() ;
		dams.add("Sardar Sarovar");
		dams.add("Nagarjuna sagar");
		dams.add("Hirakud");
		dams.add("Bhakra Nangak");
		dams.add("TungaBhadra");
		dams.add("Rihad");
		out.println(dams);
		out.println(dams.size());
		out.println(dams.toString());
		
		//Iterator iter=colours.
		
		
		for( Object d:dams)
		{
			out.println(d);
			
		}
		
	}

}
