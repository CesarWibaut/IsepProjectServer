package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

/**
 * Servlet implementation class TestWeka
 */
public class TestWeka extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestWeka() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Define each attribute (or column), and give it a numerical column number
				// Likely, a better design wouldn't require the column number, but
				// would instead get it from the index in the container
				Attribute a1 = new Attribute("houseSize", 0);
				Attribute a2 = new Attribute("lotSize", 1);
				Attribute a3 = new Attribute("bedrooms", 2);
				Attribute a4 = new Attribute("granite", 3);
				Attribute a5 = new Attribute("bathroom", 4);
				Attribute a6 = new Attribute("sellingPrice", 5);
				 
				// Each element must be added to a FastVector, a custom
				// container used in this version of Weka.
				// Later versions of Weka corrected this mistake by only
				// using an ArrayList
				FastVector attrs = new FastVector();
				attrs.addElement(a1);
				attrs.addElement(a2);
				attrs.addElement(a3);
				attrs.addElement(a4);
				attrs.addElement(a5);
				attrs.addElement(a6);
				 
				// Each data instance needs to create an Instance class
				// The constructor requires the number of columns that
				// will be defined.  In this case, this is a good design,
				// since you can pass in empty values where they exist.
				String s = new String();
				Instance i1 = new DenseInstance(6);
				i1.setValue(a1, 3529);
				i1.setValue(a2, 9191);
				i1.setValue(a3, 6);
				i1.setValue(a4, 0);
				i1.setValue(a5, 0);
				i1.setValue(a6, 205000);
				 
				 
				// Each Instance has to be added to a larger container, the
				// Instances class.  In the constructor for this class, you
				// must give it a name, pass along the Attributes that
				// are used in the data set, and the number of
				// Instance objects to be added.  Again, probably not ideal design
				// to require the number of objects to be added in the constructor,
				// especially since you can specify 0 here, and then add Instance
				// objects, and it will return the correct value later (so in
				// other words, you should just pass in '0' here)
				Instances dataset = new Instances("housePrices", attrs, 7);
				dataset.add(i1);
				 
				// In the Instances class, we need to set the column that is
				// the output (aka the dependent variable).  You should remember
				// that some data mining methods are used to predict an output
				// variable, and regression is one of them.
				dataset.setClassIndex(dataset.numAttributes() - 1);
				response.getWriter().println(dataset.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
