package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.RatingsDAO;

/**
 * Servlet implementation class Ratings
 */
public class Ratings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private static RatingsDAO ratingsDao = getDbi().open(RatingsDAO.class);   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ratings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ratingsDao.getAll());
		response.getWriter().println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ratingsDao.insertRatings((String)request.getSession().getAttribute("email"), request.getParameter("fid"), request.getParameter("score"));
		response.sendRedirect("movie.jsp?id="+request.getParameter("fid"));
	}

}
