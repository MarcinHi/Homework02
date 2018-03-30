package pl.coderslab;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet03")
public class Servlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html");
	
	PrintWriter out = response.getWriter();
	
	out.append("<form action='Servlet03' method='post'>");
	out.append("<div>Pole1:");
	out.append("<input type='text' name='input1'/>");
	out.append("</div>");
	out.append("<div>Pole2:");
	out.append("<input type='text' name='input2'/>");
	out.append("</div>");
	out.append("<div>Pole3:");
	out.append("<input type='text' name='input3'/>");
	out.append("</div>");
	out.append("<div>");
	out.append("<input type='submit' value='Wyslij'/>");
	out.append("</div>");
	out.append("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		
		String param1 = request.getParameter("input1");
		String param2 = request.getParameter("input2");
		String param3 = request.getParameter("input3");
	
		if(session.getAttribute("param1") == null) {
			session.setAttribute("param1", param1);
		if(session.getAttribute("param2") == null) {
			session.setAttribute("param2", param2);
		if(session.getAttribute("param3") == null) {			
			session.setAttribute("param3", param3);
		
		}}} else {
			Object p1 = session.getAttribute("param1");
			param1 = p1.toString();
			Object p2 = session.getAttribute("param2");
			param2 = p2.toString();
			Object p3 = session.getAttribute("param3");
			param3 = p3.toString();
		}
		
		PrintWriter out = response.getWriter();
		
		out.append("Pole1: " + param1);
		out.append("Pole2: " + param2);
		out.append("Pole3: " + param3);
	
	}

}
