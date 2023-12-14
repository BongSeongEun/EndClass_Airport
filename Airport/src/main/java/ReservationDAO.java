import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class ReservationDAO {
    private Connection connection;

    public ReservationDAO() {
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

    /*
     * public void addReservation(Reservation reservation) {
     * String query = "INSERT INTO Reservations (userId, airplaneId, rseat) VALUES
     * (?, ?)";
     * 
     * try (PreparedStatement preparedStatement = connection.prepareStatement(query,
     * PreparedStatement.RETURN_GENERATED_KEYS)) {
     * preparedStatement.setInt(1, reservation.getUserId());
     * preparedStatement.setInt(2, reservation.getTicketId());
     * preparedStatement.setString(3, reservation.getRseat());
     * 
     * preparedStatement.executeUpdate();
     * 
     * ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
     * if (generatedKeys.next()) {
     * reservation.setReservationId(generatedKeys.getInt(1));
     * }
     * 
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }
     * }
     */

    // 예약정보 생성 - input: 예약번호, 회원ID, 항공권ID, 선택된 좌석
    // -> {예약번호, 회원ID, 항공권ID, 선택된 좌석} 테이블 생성 후 INSERT
    public List<Reservation> addRservation(int reservationId, String userId, int airplaneId, int seat) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "INSERT INTO Reservations (reservationId, userId, airplaneId, rseat) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);
            preparedStatement.setString(2, userId);
            preparedStatement.setInt(3, airplaneId);
            preparedStatement.setInt(4, seat);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt(reservationId));
                reservation.setUserId(resultSet.getString(userId));
                reservation.setAirplaneId(resultSet.getInt(airplaneId));
                reservation.setRseat(resultSet.getInt(seat));

                reservations.add(reservation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 예약정보 SELECT - input: 회원ID
    // -> {예약번호, 선택된 항공권ID, 선택된 좌석} 테이블 SELECT
    public Reservation UserReservation(String userId) {
        // List<Reservation> userreservations = new ArrayList<>();
        String query = "SELECT reservationId, airplaneId, rseat FROM Reservations WHERE userId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setAirplaneId(resultSet.getInt("selectedAirplaneId"));
                reservation.setRseat(resultSet.getInt("selectedSeat"));
                return reservation;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    // 우리 비회원조회가 없음! 로그인된 회원 ID 확인해서 걔가 예약한 정보를 다 출력
    // 회의필요
    public Reservation getReservationById(int reservationId) {
        String query = "SELECT * FROM Reservations WHERE reservationId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reservationId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setUserId(resultSet.getString("userId"));
                reservation.setAirplaneId(resultSet.getInt("airplaneId"));

                return reservation;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}