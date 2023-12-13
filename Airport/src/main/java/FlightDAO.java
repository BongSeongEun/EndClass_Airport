import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    private Connection connection;

    // 생성자, 연결 설정 메서드 등 필요한 코드 추가

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM Flights";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setFlightId(resultSet.getInt("flightId"));
                flight.setAirlineId(resultSet.getString("airlineId"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setTime(resultSet.getString("time"));
                flight.setSeat(resultSet.getString("seat"));
                flight.setPrice(resultSet.getDouble("price"));

                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
}
