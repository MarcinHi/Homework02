package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		List<String> basket = (List<String>) session.getAttribute("basket");
		Double sum = 0.0;
		PrintWriter out = response.getWriter();
		
		out.append("<div>");
		out.append("Twoj koszyk:<br>");
		for(int i = 0; i < basket.size(); i++) {
			String product = basket.get(i);
			String[]productDiv = product.split("->");
			String name = productDiv[0];
			Integer quantity = Integer.parseInt(productDiv[1]);
			Double price = Double.parseDouble(productDiv[2]);
			out.append(name + " - " + quantity + " x " + price + "zl = " + (quantity*price) + "zl<br>");
			sum += quantity*price;
		}
		out.append("<br>");
		out.append("SUMA: " + sum + "zl");		
		out.append("</div>");
	}


}
