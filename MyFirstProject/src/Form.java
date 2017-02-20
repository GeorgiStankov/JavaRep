

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<HTML>");
		response.getWriter().println("<BODY>");
		response.getWriter().println("<form action=\"demo\">");
		response.getWriter().println("ID: <input type=\"text\" name=\"ID\" value=\"\"><br>");
		response.getWriter().println("Topic: <input type=\"text\" name=\"Topic\" value=\"\"><br>");
		response.getWriter().println("Date: <input type=\"text\" name=\"Date\" value=\"\"><br>");
		response.getWriter().println("<input type=\"submit\" value=\"Submit\">");
		response.getWriter().println("<input type=\"submit\" value=\"Cancel\">");
 		response.getWriter().println("</form>");
 					
		response.getWriter().println("</BODY>");
		response.getWriter().print("</HTML>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
