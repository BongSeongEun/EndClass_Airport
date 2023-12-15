
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/air.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext ctx;
	FlightDAO f_dao;
	ReservationDAO r_dao;
	MemberDAO m_dao;

	Member member;
	boolean b_login =false;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		f_dao = new FlightDAO();
		r_dao = new ReservationDAO();
		m_dao = new MemberDAO();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		b_login = Boolean.parseBoolean(request.getParameter("b_login"));
		if (action == null) {
			action = "main"; // 기본 액션으로 항공권 목록 표시
		}

		try {
			switch (action) {
				case "addUser":
					addUser(request, response);
					break;
				case "getUserById":
					getUserById(request, response);
					break;
				case "book":
					book(request, response);
					break;
				case "toreserve3":
					toreserve3(request, response);
					break;
				case "selectSeat":
					selectSeat(request, response);
				case "CheckReserve":
					CheckReserve(request, response);
				default:
					RequestDispatcher dispatcher = request.getRequestDispatcher("/" + action + ".jsp");
					dispatcher.forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 회원가입 화면 기능
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Member m = new Member();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		

		m_dao.addMember(id, pw);
		response.sendRedirect("air.nhn?action=join_succes");

	}

	// 로그인 화면 기능
	public void getUserById(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		Member m = new Member();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		m = m_dao.getMemberById(id);
		if (pw.equals(m.getPassword())) {
			member = m;
			b_login =true;
			request.setAttribute("user", m);
			response.sendRedirect("air.nhn?action=main");
		} else {
			member = new Member();
			b_login =false;
			response.sendRedirect("air.nhn?action=login_fall");
		}
	}

	// 예약 화면 기능
	public void book(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String departure = request.getParameter("departure");
		String destintation = request.getParameter("destintation");
		List<Flight> f = new ArrayList<>();

		List<Integer> l_id = f_dao.getCorrectFlightIds(departure, destintation);

		for (int id : l_id) {
			f.add(f_dao.getFlightID(id));
		}

		request.setAttribute("l_flight", f);
		
		response.sendRedirect("air.nhn?action=reserve2");
	}
	public void toreserve3(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int flightid = Integer.parseInt(request.getParameter("btn"));
		
		
		request.setAttribute("flightid",flightid );
		
		
		response.sendRedirect("air.nhn?action=reserve3");
	}
	
	public void selectSeat(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		 Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
	     random.setSeed(System.currentTimeMillis());
		int seat = Integer.parseInt(request.getParameter("seat"));
		int flightid = Integer.parseInt(request.getParameter("flightId"));
		int reservationId =random.nextInt(1000);
		r_dao.addRservation(reservationId,member.getId(), flightid, seat);
		
		request.setAttribute("flightid",flightid );
		
		
		response.sendRedirect("air.nhn?action=reservecomplete");
	}
	
	
	//예약 확인 화면 
	
	public void CheckReserve(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		Flight f = new Flight();
		Reservation r = new Reservation();
		r=r_dao.UserReservation(member.getId());
		f = f_dao.getFlightID(r.getFlightId());
		request.setAttribute("flight",f );
		request.setAttribute("reservatuin",r );
		
		response.sendRedirect("air.nhn?action=reserveCheck");
		
	}
	

	



}
