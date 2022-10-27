import java.sql.*;
import java.util.Scanner;

public class Result {
    Scanner sc = new Scanner(System.in);
    int check = 0;

    // ArrayList<String> list = null;
    // 0. 초기 출력1
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

    public int getLastPid() {
        String url = "jdbc:mysql://127.0.0.1:3306/semi_project";
        String user = "root";
        String password = "root";
        String sql = "SELECT PARTICIPANTS_UID FROM PARTICIPANTS";
        int lastPid = 0;
        
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                lastPid = Integer.parseInt(rs.getString("PARTICIPANTS_UID"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastPid;
    }

    // 2. 질문 별 총 답변 수
    // sql에서 통계를 낼건지..vs 자바로 통계를 낼건지...
    public void calculateAnswers(Connection connection, Statement statement, PreparedStatement preparedStatement) {
        try {
            System.out.println("    답(1)   답(2)   답(3)   답(4)   답(5)");
            String queryAnswer = "SELECT QUESTIONS_UID,ANSWER_UID FROM result ORDER BY QUESTIONS_UID;";
            String queryAnswer2 = "SELECT QUESTIONS_UID,ANSWER_UID FROM result WHERE QUESTIONS_UID = ? ORDER BY QUESTIONS_UID;";

            ResultSet rs = statement.executeQuery(queryAnswer);
            preparedStatement = connection.prepareStatement(queryAnswer2);

            while (rs.next()) {
                int resultArr[] = { 0, 0, 0, 0, 0 };
                String qid = rs.getString("QUESTIONS_UID");
                ResultSet rs2;
                int getCheckPid = getLastPid();
                preparedStatement.setString(1, qid);
                rs2 = preparedStatement.executeQuery();
                while (rs2.next()) {
                    if (rs2.getString("ANSWER_UID").equals("1")) {
                        resultArr[0]++;
                    } else if (rs2.getString("ANSWER_UID").equals("2")) {
                        resultArr[1]++;
                    } else if (rs2.getString("ANSWER_UID").equals("3")) {
                        resultArr[2]++;
                    } else if (rs2.getString("ANSWER_UID").equals("4")) {
                        resultArr[3]++;
                    } else if (rs2.getString("ANSWER_UID").equals("5")) {
                        resultArr[4]++;
                    }
                }
                check ++;
                if (check == getCheckPid) { //

                    System.out.print("Q" + rs.getString("QUESTIONS_UID") + "   ");
                    for (int i = 0; i < 5; i++) {
                        System.out.print(resultArr[i] + "       ");
                    }
                    System.out.println();
                    check = 0;
                }   
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
