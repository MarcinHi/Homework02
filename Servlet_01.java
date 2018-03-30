package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		Map<String, Double> map = new HashMap<>();
		map.put("eurUsd",1.2);
		map.put("eurPln",4.2);
		map.put("usdPln",3.2);
		PrintWriter out = response.getWriter();
		String selection = request.getParameter("exchange");
		String amountStr = request.getParameter("amount");
		int amount = Integer.parseInt(amountStr);
		switch (selection) {
		case "eurUsd":
			out.append("Zamiana " + amountStr + " EUR na USD, da nam: " + (map.get("eurUsd")*amount) + " USD.");
			break;
		case "usdEur":
			out.append("Zamiana " + amountStr + " USD na Eur, da nam: " + (amount/map.get("eurUsd")) + " EUR.");
			break;
		case "eurPln":
			out.append("Zamiana " + amountStr + " EUR na PLN, da nam: " + (map.get("eurPln")*amount) + " PLN.");
			break;
		case "plnEur":
			out.append("Zamiana " + amountStr + " PLN na EUR, da nam: " + (amount/map.get("eurUsd")) + " EUR.");
			break;
		case "usdPln":
			out.append("Zamiana " + amountStr + " USD na PLN, da nam: " + (map.get("eurUsd")*amount) + " PLN.");
			break;
		case "plnUsd":
			out.append("Zamiana " + amountStr + " PLN na USD, da nam: " + (amount/map.get("eurUsd")) + " USD.");
			break;
		default:
			break;
		}
		response.getWriter().append("<br>").append("<a href='index_01.html'>Wroc</a>");
	
	}

}
