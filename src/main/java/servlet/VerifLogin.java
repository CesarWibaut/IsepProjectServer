package servlet;

import static api.BDDFactory.getDbi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;

/**
 * Servlet implementation class VerifLogin
 */
public class VerifLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	

	private static UsersDAO usersDao = getDbi().open(UsersDAO.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(usersDao.login(request.getParameter("email"), request.getParameter("password").hashCode()+"") != null){
			request.getSession().setAttribute("firstname", usersDao.getFirstName(request.getParameter("email")) );
			request.getSession().setAttribute("email", request.getParameter("email"));
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
