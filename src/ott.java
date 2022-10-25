import java.sql.*;
import java.util.Scanner;

public class ott {
    Scanner sc = new Scanner(System.in);

    public void printSurveyMenu(Statement statement){
        String input;
        while(true){

             System.out.println("-------------------------");
             System.out.println("설문지 목록");
             System.out.println("1. OTT 구독 서비스 만족도 \n 2.기타 \n 3. 기타");
             System.out.println("-------------------------");

             input = sc.next();
             if(input.equals("1")){
                runSurvey(statement);
                break;
             }else{
                System.out.println("* 잘못된 입력입니다.");
              continue;
             }
        }
    }

    public void runSurvey(Statement statement){
        String query = "SELECT * FROM questions ORDER BY QUESTIONS_UID";
        System.out.println("이름을 입력하세요");
        String name = sc.nextLine();
        try{
            ResultSet rs = statement.executeQuery(query);

            System.out.println("– 모든 질문의 답은 한가지만 선택 가능합니다.");
            System.out.println("-------------------------------------------");
            while(rs.next()){
                System.out.println(rs.getString("CONTENTS"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
