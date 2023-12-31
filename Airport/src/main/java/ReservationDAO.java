import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;

public class ReservationDAO {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

    public Connection open() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
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
    public List<Reservation> addRservation(int reservationId, String MemberId, int FlightId, int SeatSelection)
            throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "INSERT INTO Reservations (reservationId, MemberId, FlightId, SeatSelection) VALUES (?, ?, ?, ?)";

        Connection conn = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, reservationId);
            preparedStatement.setString(2, MemberId);
            preparedStatement.setInt(3, FlightId);
            preparedStatement.setInt(4, SeatSelection);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt(reservationId));
                reservation.setMemberId(resultSet.getString(MemberId));
                reservation.setFlightId(resultSet.getInt(FlightId));
                reservation.setSeatSelection(resultSet.getInt(SeatSelection));

                reservations.add(reservation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    // 예약정보 SELECT - input: 회원ID
    // -> {예약번호, 선택된 항공권ID, 선택된 좌석} 테이블 SELECT
    public Reservation UserReservation(String MemberId) throws SQLException {
        // List<Reservation> userreservations = new ArrayList<>();
        String query = "SELECT reservationId, FlightId, SeatSelection FROM Reservations WHERE MemberId = ?";

        Connection conn = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setString(1, MemberId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setFlightId(resultSet.getInt("selectedFlightId"));
                reservation.setSeatSelection(resultSet.getInt("SeatSelection"));
                return reservation;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    // 우리 비회원조회가 없음! 로그인된 회원 ID 확인해서 걔가 예약한 정보를 다 출력
    // 회의필요
    public Reservation getReservationById(int reservationId) throws SQLException {
        String query = "SELECT * FROM Reservations WHERE reservationId = ?";
        Connection conn = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
            preparedStatement.setInt(1, reservationId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setMemberId(resultSet.getString("MemberId"));
                reservation.setFlightId(resultSet.getInt("FlightId"));

                return reservation;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return null;
    }

}
