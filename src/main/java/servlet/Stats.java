package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecommandationDAO;

/**
 * Servlet implementation class Stats
 */
public class Stats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RecommandationDAO recommandationDao = getDbi().open(RecommandationDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stats() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("reset")!=null) {
			recommandationDao.reset();
		}else {
			response.getWriter().println(recommandationDao.getStats());
		}
	}

}
