package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.RatingsDAO;
import recommandation.Recommandation;

/**
 * Servlet implementation class GlobalRating
 */
public class Recommandations extends HttpServlet { 
	
	Recommandation rec = new Recommandation();
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null) {
			email = request.getParameter("email");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(rec.getRecommandation(email));
		response.getWriter().println(json);
	}
}
