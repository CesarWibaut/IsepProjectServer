

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.*;

import static api.BDDFactory.getDbi;
import static api.BDDFactory.tableExist;
/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UsersDAO usersDao = getDbi().open(UsersDAO.class);
	private static RatingsDAO ratingsDao = getDbi().open(RatingsDAO.class);   
	
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public Test() throws SQLException {
        super();
        
        usersDao.dropTable();
        ratingsDao.dropTable();
       // dao.createTable();
        if(!tableExist("users")) {
        	usersDao.createTable();
        	System.out.println("creating table users ");
        }else {
        	System.out.println("users already created !");
        }
        
        if(!tableExist("ratings")) {
        	ratingsDao.createTable();
        	System.out.println("creating table ratings");
        }else {
        	System.out.println("ratings already created!");
        }
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		dao.insert();
//		System.out.println("oui on insert oui");
//		System.out.println(dao.get());
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dao.getAll());
//		response.getWriter().println(json);
		response.getWriter().println("All done");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
