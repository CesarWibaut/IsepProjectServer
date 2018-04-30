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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(ratingsDao.getMyRatings((String) request.getSession().getAttribute("email")));
		response.getWriter().println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		System.out.println("POST");
		if (ratingsDao.getExistingRating((String) session.getAttribute("email"), request.getParameter("fid")) == null) {
			System.out.println("INSERT");
			ratingsDao.insertRatings((String) session.getAttribute("email"), request.getParameter("fid"),
					request.getParameter("score"));
		} else {
			System.out.println("UPDATE");
			ratingsDao.updateRating((String) session.getAttribute("email"), request.getParameter("fid"),
					request.getParameter("score"));
		}
		
		response.sendRedirect("movie.jsp?id=" + request.getParameter("fid"));
	}

}
