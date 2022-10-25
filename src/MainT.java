import java.sql.*;

public class MainT {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://127.0.0.1:3306/semi_project";
        String user = "root";
        String password = "*khacademy!";

        try {
            // mysql 접속
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 접속 완료");
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = null;

            // 설문 클래스 선언
            //new Result().calculateParticipants(connection ,statement, preparedStatement);
            new OttSurvey().runSurvey(connection ,statement, preparedStatement); 
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
