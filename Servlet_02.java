package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		double result = 0;
		int j = 0;
		int number;
		String input = request.getParameter("input");
		
		char[] inputCharTable = input.toCharArray();

		for (int i = 0; i < inputCharTable.length; i++) {
			char c = inputCharTable[i];
			if (c != '0' && c != '1') {
				out.append("Nie podales poprawnego ciagu binarnego!<br>");
				out.append("<a href='index_02.html'>Wroc na poprzednia strone</a>");
				return;
			}
		}
		for (int i = inputCharTable.length - 1; i >= 0; i--) {
			double potega = Math.pow(2, j);
			number = Character.getNumericValue(inputCharTable[i]);
			result += number * potega;
			j++;
		}
		out.append(input + " to liczba " + result + "<br>");
		out.append("<a href='index_02.html'>Wroc na poprzednia strone</a>");
	}

}
