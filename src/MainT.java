import java.sql.*;

public class MainT {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3306/semi_project";
        String user = "root";
        String password = "root";

        try {
            // mysql 접속
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 접속 완료");
            Statement statement = connection.createStatement();

            // 설문 클래스 선언
            new Result().calculateParticipants(statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
