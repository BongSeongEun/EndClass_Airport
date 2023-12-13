

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDAO f_dao;
	ReservationDAO r_dao;
	UserDAO u_dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException{
        super.init(config);
        f_dao = new FlightDAO();
    	r_dao = new ReservationDAO();
    	u_dao = new UserDAO() ;
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		f_dao = new FlightDAO();
    	r_dao = new ReservationDAO();
    	u_dao = new UserDAO() ;
	}

}
