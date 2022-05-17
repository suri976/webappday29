package com.task;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculatir
 */
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fnum=request.getParameter("fnum");
		String snum=request.getParameter("snum");
		int n1=Integer.parseInt(fnum);  
		int n2=Integer.parseInt(snum);  
		PrintWriter out=response.getWriter();
		
		String opr=request.getParameter("opr");
		double result=0;
		if(opr.equals("+")) result=n1+n2;
		if(opr.equals("-")) result=n1-n2; 
		if(opr.equals("*")) result=n1*n2; 
		if(opr.equals("/")) result=n1/n2; 

		out.println("<h1> Result = "+result); 
		 out.println("</body></html>");

		
	
	}

}