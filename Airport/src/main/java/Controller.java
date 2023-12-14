

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "main"; // 기본 액션으로 항공권 목록 표시
        }

        try {
        switch (action) {
        case "addUser":
				addUser(request,response);
            break;
        case "getUserById":
        	getUserById(request,response);
            break;
        case "getAllFlights":
        	getAllFlights(request,response);
            break;
            
        case "setFlights":
        	setFlights(request,response);
            break;
        case "setReservationId":
        	setReservationId(request,response);
            break;
        case "getReservationById":
        	getReservationById(request,response);
            break;
        case "getReservation":
        	getReservationById(request,response);
            break;
        default:
       	 RequestDispatcher dispatcher = request.getRequestDispatcher("/"+action+".jsp");
			dispatcher.forward(request, response);
           
        }		
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	//회원가입 화면 기능 
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		User u = new User();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");;
			
		u_dao.addUser(id,pw);
		response.sendRedirect("air.nhn?action=main");
	
	}
	//로그인 화면 기능  
	public void getUserById(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

			User u = new User();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			u = u_dao.getUserById(id);
			if(pw.equals(u.getPassword())){
				request.setAttribute("b_login",true);
				request.setAttribute("user",u);
				
				response.sendRedirect("air.nhn?action=login");
			}else {
				request.setAttribute("b_login",false);
				response.sendRedirect("air.nhn?action=login");
			}
	}
	
	//예약 화면 기능  
	public void book(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String departure = request.getParameter("departure");
		String destintation = request.getParameter("destintation");
		List<Flight> f = new ArrayList<>();
		
		List<Integer> l_id = f_dao.getCorrectAirplaneIds(departure,destintation);
		
		
		for(int id :l_id){
			f.add(f_dao.getAirplaneID(id));
		}
		
		request.setAttribute("l_flight", f);
	}
	
	
	public String getAllFlights(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<Flight> list;
		try {
			
			
		}catch(Exception e){
			e.printStackTrace();
			ctx.log("뉴스 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다!!");
		} 
		return "redirect:/news.nhn?action=reserve";
	}
	public String setFlights(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Flight f = new Flight();
		int flightid = Integer.parseInt(request.getParameter("Flightid"));
		
		request.setAttribute("seatlist", f);
		request.setAttribute("flightId", flightid);
		return "redirect:/news.nhn?action=setSelect";
	}

	public String setReservationId(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int seat = Integer.parseInt(request.getParameter("seat"));
		int flightid = Integer.parseInt(request.getParameter("Flightid"));
		Reservation r = new Reservation();

		
		return "main";
	}
	
	public void getReservationById(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {		
		response.sendRedirect("air.nhn?action=join");
	}
	public String getReservation(HttpServletRequest request) throws SQLException {
		
		Reservation r = new Reservation();
		
		request.setAttribute("reservation", r);
		return "main";
	}
	
	
	
	
	
}

