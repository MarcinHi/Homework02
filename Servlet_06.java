package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_06")
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		Double num1 = Double.parseDouble(request.getParameter("num1"));
		Double num2 = Double.parseDouble(request.getParameter("num2"));
		Double num3 = Double.parseDouble(request.getParameter("num3"));
		Double num4 = Double.parseDouble(request.getParameter("num4"));

		PrintWriter out = response.getWriter();
		out.append("Liczby:<br>");
		out.append("- " + num1 + "<br>");
		out.append("- " + num2 + "<br>");
		out.append("- " + num3 + "<br>");
		out.append("- " + num4 + "<br>");
		out.append("Srednia:<br>");
		out.append("- " + ((num1 + num2 + num3 + num4) / 4) + "<br>");
		out.append("Suma:<br>");
		out.append("- " + (num1 + num2 + num3 + num4) + "<br>");
		out.append("Iloczyn:<br>");
		out.append("- " + (num1 * num2 * num3 * num4) + "<br>");
		visitCookie1(request, response, out);
	}

	private void visitCookie1(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		Cookie counter_Servlet06 = new Cookie("Servlet_06_counter", "1");
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			out.append("Witaj po raz pierwszy!<br>");
			response.addCookie(counter_Servlet06);
		
		} else {
		for (Cookie c : cookies) {
				if ("Servlet_06_counter".equals(c.getName())) {
					Integer n = Integer.parseInt(c.getValue());
					n++;
					out.append("Witaj ponownie. Odwiedziles nas juz po raz " + n + "<br>");
					counter_Servlet06.setValue(n.toString());
					response.addCookie(counter_Servlet06);
					break;
					}
			}
	}
}}
