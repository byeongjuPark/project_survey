import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        
        String url = "jdbc:mysql://127.0.0.1:3306/project_01";
        String user = "root";
        String password = "*khacademy!";
        
        Scanner sc = new Scanner(System.in);
        

        try{
            // mysql 접속
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB 접속 완료");
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = null;

            // 설문 클래스 선언
            
            
            
    
            while(true) {
                System.out.println("----------------------------------------");
                System.out.println("설문조사 프로그램 \n P. 설문 시작 \n S. 통계 \n Q. 종료");
                System.out.println("----------------------------------------");
                
                System.out.println("선택 >> ");
                String ch = sc.next();
                
                if(ch.equals("P")) {
                    //OttSurvey ott = new OttSurvey();
                    //ott.OttSurvey(statement);
                } else if (ch.equals("S")) {
                    new Result().calculateParticipants(connection ,statement, preparedStatement);
                } else if (ch.equals("Q")) {
                    System.out.println("답변해 주셔서 감사합니다");
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        sc.close();


        
    }
}
