package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RatingsDAO;

/**
 * Servlet implementation class GlobalRating
 */
public class GlobalRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RatingsDAO ratingsDao = getDbi().open(RatingsDAO.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalRating() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}else {
			response.getWriter().println(ratingsDao.getAvgScore(request.getParameter("id")));
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
