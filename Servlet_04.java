package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_04")
public class Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie visits = new Cookie("visits", "1");
		Cookie[] cookies = request.getCookies();

		try{
			for (Cookie c : cookies) {
			if ("visits".equals(c.getName())) {
				String cookieValue = c.getValue();
				Long visitsLong = Long.parseLong(cookieValue);
				out.append("Witaj, odwiedziles nas juz " + cookieValue + " razy");
				visitsLong++;
				visits.setValue(visitsLong.toString());
				response.addCookie(visits);

			} else {
				firstVisit(response, out, visits);

			}
		}
		}catch(NullPointerException e) {
			firstVisit(response, out, visits);
		}
	}

	private void firstVisit(HttpServletResponse response, PrintWriter out, Cookie visits) {
		out.append("Witaj pierwszy raz na naszej stronie");
		visits.setMaxAge(31536000);
		response.addCookie(visits);
	}
}
