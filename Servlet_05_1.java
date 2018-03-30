package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String> basket = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.append("<div>");
		out.append("Podaj produkt, ktory chcesz dodac do koszyka:<br>");
		out.append("<form action='Servlet_05_1' method='post'>");
		out.append("<input type='text' name='name' value='nazwa'/> - nazwa produktu<br>");
		out.append("<input type='number' name='quantity' value='0'/> - ilosc produktow<br>");
		out.append("<input type='double' name='price' value='0.00'/> - cena jednego produktu<br>");
		out.append("<input type='submit' value='Wyslij'/><br>");
		out.append("</form>");
		out.append("</div>");
		out.append("<a href='Servlet_05_2'>Zobacz koszyk</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String product = name + "->" + quantity + "->" + price;
		basket.add(product);
		session.setAttribute("basket", basket);
		response.getWriter().append("Produkt dodany do koszyka<br>");
		response.getWriter().append("<div>");
		response.getWriter().append("<a href='Servlet_05_1'>OK</a>");
		response.getWriter().append("</div>");
	}

}
