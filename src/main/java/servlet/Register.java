package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;

import dao.UsersDAO;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UsersDAO usersDao = getDbi().open(UsersDAO.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je créé un compte");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		usersDao.insert(first, last, email, password.hashCode()+"");
	}

}
