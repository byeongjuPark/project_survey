import java.sql.*;
import java.util.Scanner;

public class OttSurvey {
   public OttSurvey(Statement statement) {

      Scanner sc = new Scanner(System.in);

      String input;
      while (true) {

         System.out.println("-------------------------");
         System.out.println("설문지 목록");
         System.out.println("1. OTT 구독 서비스 만족도 \n 2.기타 \n 3. 기타");
         System.out.println("-------------------------");

         input = sc.next();
         if (input.equals("1")) {
            // OttSurvey(statement);
            break;
         } else {
            System.out.println("* 잘못된 입력입니다.");
            continue;
         }

         System.out.println("이름을 입력하세요");
         String name = sc.nextLine();

         System.out.println("– 모든 질문의 답은 한가지만 선택 가능합니다.");
         System.out.println("-------------------------------------------");

         // 질문 select 해서 담아온 객체
         String query = "SELECT * FROM semi_project.questions";
         ResultSet questionRs;

         // 답안 select 해서 담아온 객체
         String query1 = "SELECT * FROM answers";

         ResultSet answerRs;

         String query3 = "SELECT * FROM semi_project.participants WHERE PARTICIPANTS_UID IN(1,2,3)";

         ResultSet parRs;

         try {
            questionRs = statement.executeQuery(query);
            answerRs = statement.executeQuery(query1);
            parRs = statement.executeQuery(query3);

            // 질문 문항
            while (questionRs.next()) { // next()는 다음 행이 있다면 true, while문이 true때까지 반복해서 돎.

               // 출력시 Q1. ~ 나옴.
               String question_uid = questionRs.getString("QUESTION_UID");
               System.out.println("Q" + question_uid + ".");

               // 출력시 문항 내용 나옴.
               System.out.println("CONTENTS:" + questionRs.getString("CONTENTS"));

               while (answerRs.next()) {
                  String answer_uid = answerRs.getString("ANSWER_UID");
                  System.out.println("A" + answer_uid + ".");
                  System.out.println("ANSWER" + answerRs.getString("ANSWERS"));

                  String participants_uid = parRs.getString("PARTICIPANTS_UID");
                  System.out.println("P" + participants_uid + ".");
                  System.out.println(name + parRs.getString("NAME"));

                  // 답안을 스캐너로 받기

                  System.out.println("답:>>>");
                  String answer = sc.nextLine();

                  // 결과값
                  String query2 = "INSERT INTO result (PARTICIPANTS_UID, ANSWER_UID, QUESTIONS_UID) VALUES ('participants_uid', 'answer_uid', 'question_uid')";
                  statement.executeQuery(query2);

               }
               System.out.println();
            }
         } catch (Exception e) {
         }
      }
   }
}

/*
 * -- 회원 가입
 * INSERT INTO `semi_project`.`participants` (`PARTICIPANTS_UID`, `NAME`) VALUES
 * ('1', '박병주');
 * -- 답안 출력
 * SELECT answer FROM (questions
 * INNER JOIN questions_answers ON questions_answers.QUESTIONS_UID =
 * questions.QUESTIONS_UID)
 * INNER JOIN answers ON questions_answers.ANSWER_UID = answers.ANSWER_UID
 * WHERE questions.QUESTIONS_UID = '1';
 * -- 사용자 답 입력
 * INSERT INTO result (PARTICIPANTS_UID, ANSWER_UID, QUESTIONS_UID) VALUES ('1',
 * '1', '1');
 */
