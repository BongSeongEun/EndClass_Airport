import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
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

    // User 객체 생성해서 사용자를 데이터베이스에 추가
    public void addUser(String userId, String password) {
        List<User> users = new ArrayList<>();
        String query = "INSERT INTO Users (userId. password) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();

            user.setUserId(resultSet.getString("userId"));
            user.setPassword(resultSet.getString("password"));

            users.add(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 조회 있으면 User객체 반환 없으면 null 반환
    public User getUserById(String userId) {
        String query = "SELECT * FROM Users WHERE userId = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getString("userId"));
                user.setPassword(resultSet.getString("password"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
