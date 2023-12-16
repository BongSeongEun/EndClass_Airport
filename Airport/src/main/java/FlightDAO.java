import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class FlightDAO {
	 final String JDBC_DRIVER = "org.h2.Driver";
	 final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

	  public Connection open() {
	        Connection conn = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
	        } catch (Exception e) { e.printStackTrace(); }
	        
	        
	        return conn;
	    }

    // 항공권ID - input: airplanId
    // -> {항공사, 출발지, 도착지, 시간, 가격} 보여줌
    public Flight getFlightID(int flightId) throws SQLException {
        Flight flight = new Flight();
        String query = "SELECT (airline, departureairport, arrivalairport, time, price) FROM Flight WHERE flightId = ?";

        Connection conn  = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, flightId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flight.setAirline(resultSet.getString("airline"));
                flight.setDepartureairport(resultSet.getString("departureairport"));
                flight.setArrivalairport(resultSet.getString("arrivalairport"));
                flight.setTime(resultSet.getString("time"));
                flight.setPrice(resultSet.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

    // 선택된 airplaneId?

    // 선택된 출발지/도착지로 된 항공권ID SELECT - input: 선택된 출발지, 선택된 도착지
    // {항공권ID} <- 출발지와 도착지가 같은 모든 항공권ID 테이블
    public List<Flight> getCorrectFlight(String departureairport, String arrivalairport) throws SQLException {
        List<Flight> CorrectFlight = new ArrayList<>();
        String query = "SELECT * FROM Flight WHERE departureairport = ? AND arrivalairport = ?";

        Connection conn = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, departureairport);
            preparedStatement.setString(2, arrivalairport);

            Flight flight = new Flight();
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flight.setAirline(resultSet.getString("airline"));
                flight.setDepartureairport(resultSet.getString("departureairport"));
                flight.setArrivalairport(resultSet.getString("arrivalairport"));
                flight.setTime(resultSet.getString("time"));
                flight.setPrice(resultSet.getDouble("price"));
                CorrectFlight.add(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return CorrectFlight;
    }
    // 모든 시트 표시
    // 선택된 시트(1110)같은 숫자 모음 다 보여주는걸로 수정?
    public List<Flight> getAlltseats() throws SQLException {
        List<Flight> allseats = new ArrayList<>();
        String query = "SELECT seat FROM Flight";
        Connection conn  = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        
        try{
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight allseat = new Flight();
                allseat.setSeat(resultSet.getInt("seat"));
                allseats.add(allseat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allseats;
    }

    // // 선택된 시트 저장 - input: 항공권ID(11) + 선택된 좌석번호(10)
    // // {선택된 자리(1110)} 저장
    // // -> SelectdSeats에 있는 숫자는 다시 못넣음 => 중복 조회 _ 확인용?
    // public List<Flight> addSelectedSeats(int FlightId, int seat) {
    // String airplanid_s = Integer.toString(FlightId); // 11
    // String selectseat_s = Integer.toString(seat); // 10
    // String selectedSeatnum_s = airplanid_s + selectseat_s; // "1110"
    // int selectedSeatnum_i = Integer.parseInt(selectedSeatnum_s); // 1110

    // String query = "INSERT INTO Flight (selectedseat_num) VALUES (?)";
    // // selectedseat_num == selectedseat_num 이면 빠꾸 아니면 저장

    // try (PreparedStatement preparedStatement =
    // connection.prepareStatement(query)) {
    // preparedStatement.setInt(1, selectedSeatnum_i);

    // } catch (SQLException e) {
    // e.printStackTrace();
    // }
    // return null;
    // }

}

// public List<Flight> getAllFlights() {
// List<Flight> flights = new ArrayList<>();
// String query = "SELECT * WHERE AirplaneId = ?";
// try (PreparedStatement preparedStatement =
// connection.prepareStatement(query)) {
// ResultSet resultSet = preparedStatement.executeQuery();
// while (resultSet.next()) {
// Flight flight = new Flight();
// flight.setAirline(resultSet.getString("airline"));
// flight.setSource(resultSet.getString("source"));
// flight.setDestination(resultSet.getString("destination"));
// flight.setTime(resultSet.getString("time"));
// flight.setPrice(resultSet.getDouble("price"));
// flights.add(flight);
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return flights;
// }
// public List<Flight> getSeats() {
// List<Flight> seats = new ArrayList<>();
// String query = "SELECT * WHERE Seat = '?'";
// try (PreparedStatement preparedStatement =
// connection.prepareStatement(query)) {
// ResultSet resultSet = preparedStatement.executeQuery();
// while (resultSet.next()) {
// int airplaneId = resultSet.getInt("AirplaneID");
// Flight seatS = new Flight();
// seatS.setSeat(resultSet.getString("seat"));
// seats.add(airplaneId + "+" + seatS.getSeat());
// }
// } catch (SQLException e) {
// e.printStackTrace();
// }
// return seats;
// }
