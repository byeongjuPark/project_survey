import java.sql.*;
import java.util.Scanner;

public class OttSurvey {
   public OttSurvey(Statement statement){


      String query = "SELECT * FROM questions";
      ResultSet resultset;

      try {
         resultset = statement.executeQuery(query);
        
         //질문 문항 출력
         while(resultset.next()){
            String QUSTEION_UID = resultset.getString("QUESTION_UID");
            System.out.println("QUESTION_UID:"+ QUSTEION_UID);
            System.out.println("CONTENTS:"+resultset.getString("CONTENTS"));

            String Q1 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('1', '현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가')";
            String Q2 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('2', 'OTT에서 추천해주는 컨텐츠는 만족하는가')";
            String Q3 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('3', '업로드 주기는 적당하다고 생각하는가')";
            String Q4 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('4', '현재 OTT에서 제공하고 있는 자막 제공 서비스에 만족 하는가')";
            String Q5 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('5', '이용중인 구독료는 적당하다고 생각하는가')";
            String Q6 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('6', '향후 구독을 계속 유지할 생각이 있는가')";
            String Q7 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('7', '지인에게 해당 서비스를 추천할 의향이 있는가')";
            statement.execute(Q1);
            statement.execute(Q2);
            statement.execute(Q3);
            statement.execute(Q4);
            statement.execute(Q5);
            statement.execute(Q6);
            statement.execute(Q7);
            
         }
      } catch (Exception e) {
            e.printStackTrace();
      }
    /*  -- 회원 가입
      INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('1', '박병주');
      -- 답안 출력
      SELECT answer FROM (questions
      INNER JOIN questions_answers ON questions_answers.QUESTIONS_UID = questions.QUESTIONS_UID)
      INNER JOIN answers ON questions_answers.ANSWER_UID = answers.ANSWER_UID
      WHERE questions.QUESTIONS_UID = '1';
      -- 사용자 답 입력
      INSERT INTO result (PARTICIPANTS_UID, ANSWER_UID, QUESTIONS_UID) VALUES ('1', '1', '1');*/

      /*Scanner sc = new Scanner(System.in);
      System.out.println("이름을 입력하세요");
      String name = sc.nextLine();

      System.out.println("– 모든 질문의 답은 한가지만 선택 가능합니다.");
      System.out.println("-------------------------------------------");
      System.out.println("Q1. 현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가?" +
                        ("(1) 전혀 아니다.	(2) 아니다. (3) 보통이다. (4) 그렇다. (5) 매우 그렇다."));
     String A1= sc.nextLine();
   
      

      try {
         String query = "INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES ('1', 'name')";

      String Q1 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('1', '현재 구독중인 OTT 에서 제공하는 컨텐츠는 만족하는가')";
      String Q2 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('2', 'OTT에서 추천해주는 컨텐츠는 만족하는가')";
      String Q3 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('3', '업로드 주기는 적당하다고 생각하는가')";
      String Q4 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('4', '현재 OTT에서 제공하고 있는 자막 제공 서비스에 만족 하는가')";
      String Q5 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('5', '이용중인 구독료는 적당하다고 생각하는가')";
      String Q6 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('6', '향후 구독을 계속 유지할 생각이 있는가')";
      String Q7 = "INSERT INTO `semi_project`.`questions` (`QUESTIONS_UID`, `CONTENTS`) VALUES ('7', '지인에게 해당 서비스를 추천할 의향이 있는가')";
    statement.execute(Q1);
    statement.execute(Q2);
    statement.execute(Q3);
    statement.execute(Q4);
    statement.execute(Q5);
    statement.execute(Q6);
    statement.execute(Q7);
   } catch (Exception e) {*/
      }
   }

