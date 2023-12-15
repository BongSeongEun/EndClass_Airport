import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection connection = null;
    PreparedStatement pstmt;

    final String JDBC_DRIVER = "org.h2.Driver";
    final String JDBC_URL = "jdbc:h2:tcp//localhost/~/jwbookdb";

    public void open() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, "jwbook", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // User 객체 생성해서 사용자를 데이터베이스에 추가
    public void addMember(String Id, String password) {
        open();
        List<Member> members = new ArrayList<>();
        String sql = "INSERT INTO Member (Id. password) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Id);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            Member member = new Member();

            member.setId(resultSet.getString("Id"));
            member.setPassword(resultSet.getString("password"));

            members.add(member);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    // 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 조회 있으면 User객체 반환 없으면 null 반환
    public Member getMemberById(String Id) {
        open();
        String query = "SELECT * FROM Members WHERE Id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Member member = new Member();
                member.setId(resultSet.getString("Id"));
                member.setPassword(resultSet.getString("password"));

                return member;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return null;
    }
}
