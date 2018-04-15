

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TestDAO;
import pojo.User;

import static api.BDDFactory.getDbi;
import static api.BDDFactory.tableExist;
/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static TestDAO dao = getDbi().open(TestDAO.class);
       
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public Test() throws SQLException {
        super();
       // dao.createTable();
        if(!tableExist("user")) {
        	dao.createTable();
        	System.out.println("création de la table");
        }else {
        	System.out.println("table déjà créée !");
        }
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao.insert();
		System.out.println("oui on insert oui");
		System.out.println(dao.get());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dao.getAll());
		response.getWriter().println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
