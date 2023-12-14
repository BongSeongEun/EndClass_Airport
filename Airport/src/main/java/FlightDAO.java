import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.DriverManager;

public class FlightDAO {
    private Connection connection;

    public FlightDAO() {
        // 데이터베이스 연결 설정
        String url = "jdbc:h2:~/test"; // H2 데이터베이스 URL
        String user = "jwbook";
        String password = "1111";

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // 항공권ID -> {항공사, 출발지, 도착지, 시간, 가격} 보여줌
    public List<Flight> getAirplaneID(int airplaneId) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT (airline, source, destination, time, price)  FROM Flight WHERE airplaneId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, airplaneId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setAirline(resultSet.getString("airline"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setTime(resultSet.getString("time"));
                flight.setPrice(resultSet.getDouble("price"));

                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

    // 선택된 출발지/도착지로 된 항공권ID SELECT - input: 선택된 출발지, 선택된 도착지
    // {항공권ID} <- 출발지와 도착지가 같은 모든 항공권ID 테이블
    public List<Integer> getCorrectAirplaneIds(String selectedSource, String selectedDestination) {
        List<Integer> CorrectAirplaneIds = new ArrayList<>();
        String query = "SELECT airplaneId FROM Flight WHERE source = ? AND destination = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedSource);
            preparedStatement.setString(2, selectedDestination);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int AirplaneID = resultSet.getInt("AirplaneID");
                CorrectAirplaneIds.add(AirplaneID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return CorrectAirplaneIds;
    }

    // 모든 시트 표시
    public List<Flight> getAllseats() {
        List<Flight> allseats = new ArrayList<>();
        String query = "SELECT seat FROM Flight";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

    // 선택된 시트 저장 - input: 항공권ID(11) + 선택된 좌석번호(10)
    // {선택된 자리(1110)} 저장
    // -> SelectdSeats에 있는 숫자는 다시 못넣음 => 중복 조회 _ 확인용?
    public List<Flight> SelectedSeats(int airplaneId, int seat) {

        String airplanid_s = Integer.toString(airplaneId); // 11
        String selectseat_s = Integer.toString(seat); // 10
        String selectedSeatnum_s = airplanid_s + selectseat_s; // "1110"
        int selectedSeatnum_i = Integer.parseInt(selectedSeatnum_s); // 1110

        String query = "INSERT INTO Flight (selectedseat_num) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, selectedSeatnum_i);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

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
