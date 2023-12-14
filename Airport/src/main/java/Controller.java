

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = "/new.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext ctx;
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
    	
    	String view = "";
    
    	if(action ==null) {
			action = "main";
		}
		
		
		if(view.startsWith("redirect:/")) {
			String rview =view.substring("redirect:/".length());
			response.sendRedirect(rview);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/"+view+".jsp");
			dispatcher.forward(request, response);
			
		}
    	
	}
	
	public String addUser(HttpServletRequest request) throws SQLException {
		User u = new User();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
			
		u.setUserId(id);
		u.setPassword(pw);
		u_dao.addUser(u);
			
		return "main";
	}
	public String getUserById(HttpServletRequest request) throws SQLException {

			User u = new User();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			u = u_dao.getUserById(id);
			if(pw.equals(u.getPassword())){
				request.setAttribute("b_login",true);
				request.setAttribute("user",u);
				
				return "main";
			}else {
				request.setAttribute("b_login",false);
				return "redirect:/news.nhn?action=login";
			}
	}
	
	
	public String getAllFlights(HttpServletRequest request) throws SQLException {
		List<Flight> list;
		try {
			list = f_dao.getAllFlights();
			request.setAttribute("flightlist", list);
		}catch(Exception e){
			e.printStackTrace();
			ctx.log("뉴스 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다!!");
		} 
		return "redirect:/news.nhn?action=reserve";
	}
	public String setFlights(HttpServletRequest request) throws SQLException {
		Flight f = new Flight();
		int flightid = Integer.parseInt(request.getParameter("Flightid"));
		f= f_dao.getAllSeat(flightid);
		request.setAttribute("seatlist", f);
		request.setAttribute("flightId", flightid);
		return "redirect:/news.nhn?action=setSelect";
	}

	public String setReservationId(HttpServletRequest request) throws SQLException {
		String seat = request.getParameter("seat");
		int flightid = Integer.parseInt(request.getParameter("Flightid"));
		Reservation r = new Reservation();
		r.setRseat(seat);
		r.setUserId(flightid); // 유저 아이디 받아오는 방법 생각하
		r.setReservationId(flightid); //랜덤함수로 난수 넣기 
		r.setTicketId(flightid);
		r_dao.addReservation(r);
		
		return "main";
	}
	
	public String getReservationById(HttpServletRequest request) throws SQLException {
		String id = request.getParameter("id");
		Reservation r =r_dao.getReservationById(id);
		
		
		request.setAttribute("reservation", r);
		
		return "main";
	}
	public String getReservation(HttpServletRequest request) throws SQLException {
		
		Reservation r = new Reservation();
		
		request.setAttribute("reservation", r);
		return "main";
	}
	
	
	
	
	
}
