import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO() {
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

    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO Reservations (userId, ticketId, rseat) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query,
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, reservation.getUserId());
            preparedStatement.setInt(2, reservation.getTicketId());
            preparedStatement.setString(3, reservation.getRseat());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                reservation.setReservationId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Reservation getReservationById(int reservationId) {
        String query = "SELECT * FROM Reservations WHERE reservationId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setUserId(resultSet.getInt("userId"));
                reservation.setTicketId(resultSet.getInt("ticketId"));

                return reservation;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Reservation getReservationByUserId(String UserId) {
        String query = "SELECT * FROM Reservations WHERE UserId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, UserId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setUserId(resultSet.getInt("userId"));
                reservation.setTicketId(resultSet.getInt("ticketId"));

                return reservation;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}