import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    // 생성자, 연결 설정 메서드 등 필요한 코드 추가

    public void addUser(User user) {
        String query = "INSERT INTO Users (password) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getPassword());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserId(generatedKeys.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
