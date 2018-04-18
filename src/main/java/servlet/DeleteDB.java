package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;

/**
 * Servlet implementation class DeleteDB
 */
public class DeleteDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static UsersDAO usersDao = getDbi().open(UsersDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usersDao.dropTable();
	}

}
