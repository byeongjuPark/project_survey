import java.sql.*;


public class Main {
    public static void main(String[] args) throws Exception {


        String url = "jdbc:mysql://127.0.0.1:3306/study_sqls";
        String user = "root";
        String password = "root";

        

        try{
            // mysql 접속
            Connection connection = DriverManager.getConnection(url, user, password);
            
            Statement statement = connection.createStatement();

            // 설문 클래스 선언
            FoodSurvey foodSurvey = new FoodSurvey();
            OttSurvey ottSurvey = new OttSurvey();
            ConcertSurvey concertSurvey = new ConcertSurvey();
            
    
        }catch(SQLException e){

        }


    }
}
