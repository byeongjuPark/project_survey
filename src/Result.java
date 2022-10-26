import java.sql.*;
import java.util.Scanner;

public class Result {
    Scanner sc = new Scanner(System.in);

    // ArrayList<String> list = null;
    // 0. 초기 출력
    public void printCalMenu(Connection connection, Statement statement, PreparedStatement preparedStatement) {

        String input;
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("1. 설문자별 답변 결과    | 2. 질문 별 총 답변 수");
            System.out.println("------------------------------------------------");
            System.out.println(">>");
            input = sc.next();
            if (input.equals("1")) {
                calculateParticipants(connection, statement, preparedStatement);
                break;
            } else if (input.equals("2")) {
                calculateAnswers(connection, statement, preparedStatement);
                break;
            } else {
                System.out.println("* 잘못된 입력입니다.");
                continue;
            }
        }

    }

    // 1. 설문자별 답변 결과
    public void calculateParticipants(Connection connection, Statement statement, PreparedStatement preparedStatement) {
        try {
            String query = "SELECT PARTICIPANTS_UID, NAME FROM participants";
            // sql문 중간에 붙은 ? 는 밑에서 preparedStatement.setString()을 통해서 치환해줄 예정
            String queryAnswer = "SELECT ANSWER_UID FROM RESULT WHERE PARTICIPANTS_UID = ? ORDER BY QUESTIONS_UID;";

            
            ResultSet resultSet = statement.executeQuery(query);
            // PreparedStatement --> Statement 의 상위호환..? 동적으로 sql문을 실행하도록 도와줌
            preparedStatement = connection.prepareStatement(queryAnswer);
            System.out.println("         Q1   Q2   Q3   Q4   Q5   Q6   Q7");
            System.out.println("이름)");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("NAME") + "   ");
                String PID = resultSet.getString("PARTICIPANTS_UID");
                // setString(1, PID) -> 첫번째 ? 를 PID로 대체
                preparedStatement.setString(1, PID);
                // 치환된 sql문 실행!
                ResultSet resultSetAnswer = preparedStatement.executeQuery();
                while (resultSetAnswer.next()) {
                    System.out.print(resultSetAnswer.getString("ANSWER_UID"));
                    System.out.print("    ");
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. 질문 별 총 답변 수
    //sql에서 통계를 낼건지..vs 자바로 통계를 낼건지...
    public void calculateAnswers(Connection connection, Statement statement, PreparedStatement preparedStatement) {
        System.out.println("질문 별 총 답변 수");
        int resultArr[] = {0,0,0,0,0};
        try {
            String queryAnswer = "SELECT QUESTIONS_UID,ANSWER_UID FROM result ORDER BY QUESTIONS_UID;";
            String queryAnswer2 = "SELECT QUESTIONS_UID,ANSWER_UID FROM result WHERE QUESTIONS_UID = ? ORDER BY QUESTIONS_UID;";
            preparedStatement = connection.prepareStatement(queryAnswer2);
            ResultSet rs = statement.executeQuery(queryAnswer);
            while(rs.next()){ // 문항번호를 돌리는 while문
                String qid = rs.getString("QUESTIONS_UID");
                preparedStatement.setString(1, qid); //
                ResultSet rs2 = preparedStatement.executeQuery(); 
                while(rs2.next()){//답을 돌리는 while문
                    
                    if(rs2.getString("ANSWER_UID").equals("1")){
                        resultArr[0]++;
                    }else if(rs2.getString("ANSWER_UID").equals("2")){
                        resultArr[1]++;
                    } else if(rs2.getString("ANSWER_UID").equals("3")) {
                        resultArr[2]++;
                    } else if(rs2.getString("ANSWER_UID").equals("4")) {
                        resultArr[3]++;
                    } else if(rs2.getString("ANSWER_UID").equals("5")) {
                        resultArr[4]++;
                    }

                }
                System.out.print("Q"+rs.getString("QUESTIONS_UID") + " ");
                System.out.print(resultArr[0]+ "   ");
                System.out.print(resultArr[1]+ "   ");
                System.out.print(resultArr[2]+ "   ");
                System.out.print(resultArr[3]+ "   ");
                System.out.print(resultArr[4]+ "   ");
                System.out.println();
                
            }

            








            //ResultSet resultSet_QuestionCount = statement.executeQuery("select count(Questions_uid) from Questions");
            // int qC = 0;
            // while(resultSet_QuestionCount.next()) {
            //     qC = Integer.parseInt(resultSet_QuestionCount.getString("count(Questions_uid)"));
            // }

            // for (int i = 0; i<qC; i++) {
            //     String Questions = Integer.toString(i+1); // i+1 + "";
            //     System.out.print("Q" + Questions);
            //     preparedStatement.setString(1, Questions); // --> 
            //     preparedStatement.setString(2, Questions);
            //     preparedStatement.setString(3, Questions);
            //     preparedStatement.setString(4, Questions);
            //     preparedStatement.setString(5, Questions);
            //     preparedStatement.setString(6, Questions);
            //     preparedStatement.setString(7, Questions);

            //     ResultSet resultSet = preparedStatement.executeQuery();

            //     resultSet.next();
            //     int count1, count2, count3, count4, count5;
            //     count1 = resultSet.getInt("1");
            //     count2 = resultSet.getInt("2");
            //     count3 = resultSet.getInt("3");
            //     count4 = resultSet.getInt("4");
            //     count5 = resultSet.getInt("5");

            //     System.out.printf("질문" + (i+1), count1, count2, count3, count4, count5);

            
            /*/
            ResultSet result_AnswerCount = statement.executeQuery("select count(answer_uid) from answers");
            int answerCount = 0;
            while(result_AnswerCount.next()) {
                answerCount = Integer.parseInt(result_AnswerCount.getString("count(answer_uid)"));
            }

            ResultSet result_Question = statement.executeQuery("select count(questions_uid) from questions");
            int questionCount = 0;
            while(result_Question.next()) {
                questionCount = Integer.parseInt(result_Question.getString("count(Questions_uid)"));
                */
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
