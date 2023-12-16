
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class controller
 */
@WebServlet("/air.nhn")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDAO f_dao;
	ReservationDAO r_dao;
	MemberDAO m_dao;

	Member member = new Member();
	boolean b_login =false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        f_dao = new FlightDAO();
		r_dao = new ReservationDAO();
		m_dao = new MemberDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		b_login = Boolean.parseBoolean(request.getParameter("b_login"));
		if (action == null) {
			action = "main"; // 기본 액션으로 항공권 목록 표시
		}

		try {
			if(action.equals("addUser")) {
				addUser(request, response);
			}
			else if(action.equals("getUser")) {
				getUser(request, response);
			}else if(action.equals("book")) {
				book(request, response);
			}else if(action.equals("toreserve3")) {
				toreserve3(request, response);
			}else if(action.equals("selectSeat")) {
				selectSeat(request, response);
			}else if(action.equals("CheckReserve")) {
				CheckReserve(request, response);
			}else {
				response.sendRedirect(action+".jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request,response);
				
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Member m = new Member();
		int id = Integer.parseInt(request.getParameter("id"));
		String pw = request.getParameter("pw");
		

		m_dao.addMember(id, pw);
		response.sendRedirect("air.nhn?action=join_succes");

	}

	// 로그인 화면 기능
	public void getUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		Member m = new Member();
		int id = Integer.parseInt(request.getParameter("id"));
		String pw = request.getParameter("password");
		m = m_dao.getMemberById(id);
		
		if (pw.equals(m.getPassword())) {
			member = m;
			b_login =true;
			response.sendRedirect("air.nhn?action=home");
		} else {
			member = new Member();
			b_login =false;
			response.sendRedirect("air.nhn?action=login_fall");
		}
	}

	// 예약 화면 기능
	public void book(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String departure = request.getParameter("DepartureAirport");
		String destintation = request.getParameter("ArrivalAirport");
		request.setAttribute("l_flight", f_dao.getCorrectFlight(departure, destintation));
		RequestDispatcher dispatcher= request.getRequestDispatcher("reserve2.jsp");
		dispatcher.forward(request, response);
	}
	public void toreserve3(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int flightid = Integer.parseInt(request.getParameter("reserveButton"));
		
		
		request.setAttribute("flightid",flightid );
		RequestDispatcher dispatcher= request.getRequestDispatcher("reserve3.jsp");
		dispatcher.forward(request, response);
	}
	
	public void selectSeat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		 Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
	     random.setSeed(System.currentTimeMillis());
		String seat = request.getParameter("seat");
		int flightid = Integer.parseInt(request.getParameter("flightid"));
		int reservationId =random.nextInt(1000);
		
		r_dao.addRservation(reservationId,member.getId(), flightid, seat);
		
		
		response.sendRedirect("air.nhn?action=reservecomplete");
	}
	
	
	//예약 확인 화면 
	
	public void CheckReserve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		Flight f = new Flight();
		List<Reservation> r =  new ArrayList<>();
		r= r_dao.UserReservation(member.getId());
		f = f_dao.getFlightID(r.get(0).getFlightId());
		request.setAttribute("flight",f );
		request.setAttribute("reservatuin",r );
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("reserveCheck.jsp");
		dispatcher.forward(request, response);
		
	}

}
