import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FlightDAO {
    private Connection connection;

    public FlightDAO() {
        // 데이터베이스 연결 설정
        String url = "jdbc:h2:~/test"; // H2 데이터베이스 URL
        String user = "";
        String password = "";

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

  

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM Flights";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setAirline(resultSet.getString("airline"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setTime(resultSet.getString("time"));
                flight.setPrice(resultSet.getDouble("price"));

                String seatString = resultSet.getString("seat");
                String[] seats = seatString.split(",");

                flight.setSeat(Arrays.asList(seats));

                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
    

    public List<Integer> getCorrectAirplaneIds(String selectedSource, String selectedDestination) {
        List<Integer> CorrectAirplaneIds = new ArrayList<>();
        String query = "SELECT AirplaneID FROM Flight WHERE Source = ? AND Destination = ?";

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

    public List<Flight> getAllseats() {
        List<Flight> allseats = new ArrayList<>();
        String query = "SELECT * FROM Seat";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Flight allseat = new Flight();
                String seatString = resultSet.getString("seat");
                String[] seats = seatString.split(",");
                allseat.setSeat(Arrays.asList(seats));

                allseats.add(allseat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allseats;
    }









    public Flight getAllSeat(int id) {
        String query = "SELECT * FROM Users WHERE userId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
               
                return new Flight();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
