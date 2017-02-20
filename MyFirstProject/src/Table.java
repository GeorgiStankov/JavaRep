

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/Table")
public class Table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<HTML>");
		response.getWriter().println("<BODY>");
		response.getWriter().println("<CENTER>");
		response.getWriter().println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=50% >");
		response.getWriter().println("<tr>");
 		response.getWriter().println("<td>Topic</td>");
 		response.getWriter().println("<td>Java</td>");
		response.getWriter().println("</tr>");
		response.getWriter().println("<tr>");
		response.getWriter().println("<td>Date</td>");
		response.getWriter().println("<td>%= new java.util.Date() %</td>");		
		response.getWriter().println("</tr>");
		response.getWriter().println("</table>");
		
		response.getWriter().println("</BODY>");
		response.getWriter().print("</HTML>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
