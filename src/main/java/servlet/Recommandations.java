package servlet;

import static api.BDDFactory.getDbi;
import static api.BDDFactory.tableExist;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.RatingsDAO;
import dao.RecommandationDAO;
import recommandation.Recommandation;

/**
 * Servlet implementation class GlobalRating
 */
public class Recommandations extends HttpServlet { 
	
	Recommandation rec = new Recommandation();
	private static RecommandationDAO recommandationDao = getDbi().open(RecommandationDAO.class);   
    /**
     * @return 
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(!tableExist("recomstats")) {
				recommandationDao.createTable();
				recommandationDao.initTable();
				System.out.println("creating table users ");
			}else {
				System.out.println("users already created !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null) {
			email = request.getParameter("email");
		}
		recommandationDao.addView();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(rec.getRecommandation(email));
		response.getWriter().println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		recommandationDao.addSuccess();
		
	}
}
