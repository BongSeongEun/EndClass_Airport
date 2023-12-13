import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationDAO {
    private Connection connection;

    // 생성자, 연결 설정 메서드 등 필요한 코드 추가

    public void addReservation(Reservation reservation) {
        String query = "INSERT INTO Reservations (userId, flightId) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, reservation.getUserId());
            preparedStatement.setInt(2, reservation.getTicketId());

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
}
