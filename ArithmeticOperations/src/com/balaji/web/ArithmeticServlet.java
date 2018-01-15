package com.balaji.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArithmeticServlet
 */
public class ArithmeticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArithmeticServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number=request.getParameter("number");
		int n=Integer.parseInt(number);
		String operation=request.getParameter("operation");
		PrintWriter out=response.getWriter();
		String message="<html><body>";
		if(operation.equals("fibonacciSeries")) {
			message+="<h5>Fibonacci series of the number, "+n+" : <br/>";
			for (int i : ArithmetcOperations.fibonacci(n)) {
				message+=i+" ";
			}
		}
		if(operation.equals("prime")) {
			message+="<h5>The given number, "+n+" is ";
			message+=(ArithmetcOperations.isPrime(n))?"a Prime.":"not a Prime.";
			message+="</h5>";
		}
		if(operation.equals("factorial")) {
			BigDecimal num=BigDecimal.valueOf(n);
			BigDecimal fact=ArithmetcOperations.findFactorial(num);
			if(fact.intValue()!=-1) {
				message+="<h5>Factorial of the given number, "+n+" is "+fact;
			}
			else {
				message+="Give value below 5400.";
			}
			message+="</h5>";
		}
		if(operation.equals("table")) {
			message+="<h5>Multiplication Table for the number, "+n+" :<br/>";
			for (String string : ArithmetcOperations.multiplicationTable(n)) {
				message+=string+"<br/>";
			}
		}
		if(operation.equals("square")) {
			message+="<h5>The given number, "+n+" is ";
			message+=(ArithmetcOperations.isSquare(n))?"a perfect square.":"not a perfect square.";
			message+="</h5>";
		}
		out.print("<html><body>"+message+"</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
