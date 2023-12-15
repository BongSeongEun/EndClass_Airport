import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
  
	 final String JDBC_DRIVER = "org.h2.Driver";
	 final String JDBC_URL = "jdbc:h2:tcp://localhost/~/jwbookdb";

	  public Connection open() {
	        Connection conn = null;
	        try {
	            Class.forName(JDBC_DRIVER);
	            conn = DriverManager.getConnection(JDBC_URL,"jwbook","1234");
	        } catch (Exception e) { e.printStackTrace(); }
	        
	        
	        return conn;
	    }
    // User 객체 생성해서 사용자를 데이터베이스에 추가
    public void addMember(String Id, String password) throws SQLException {
    	
        List<Member> members = new ArrayList<>();
        String query = "INSERT INTO Member (Id. password) VALUES (?,?)";
        
        Connection conn  = open();
    	PreparedStatement preparedStatement = conn.prepareStatement(query);
        try {
        	
        	  preparedStatement.setString(1, Id);
              preparedStatement.setString(2, password);

              ResultSet resultSet = preparedStatement.executeQuery();
              Member member = new Member();

              member.setId(resultSet.getString("Id"));
              member.setPassword(resultSet.getString("password"));

              members.add(member);
        }catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close();
        }
    }

    // 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 조회 있으면 User객체 반환 없으면 null 반환
    public Member getMemberById(String Id) throws SQLException {
    	
        String query = "SELECT * FROM Members WHERE Id = ?";
       
        Connection conn = open();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        try{

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
