package assignment;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init() throws ServletException {
		System.out.println("Init");
    }

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: Gian Facio").append(request.getContextPath());
		
		String firstName = request.getParameter("Gian");
	    String lastName = request.getParameter("Facio");
	    
		// This will determine if the input of the User is valid
		if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()) 
		{
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
			}
		else 
		{
		
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			
			// This ask for the pull the input to display an ask in Test Response
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("lastName"));
		doGet(request, response);
	}
}
