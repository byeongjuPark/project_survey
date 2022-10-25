import java.sql.*;
import java.util.Scanner;

public class Result {
    Scanner sc = new Scanner(System.in);
    //ArrayList<String> list = null;
    // 0. 초기 출력
    public void printCalMenu(Connection connection ,Statement statement, PreparedStatement preparedStatement){
        
        String input;
        while(true){
            System.out.println("------------------------------------------------");
            System.out.println("1. 설문자별 답변 결과    | 2. 질문 별 총 답변 수");
            System.out.println("------------------------------------------------");
            System.out.println(">>");
            input = sc.next();
            if(input.equals("1")){
                calculateParticipants(connection ,statement, preparedStatement);
                break;
            }else if(input.equals("2")){
                calculateAnswers(statement);
                break;
            }else{
                System.out.println("* 잘못된 입력입니다.");
                continue;
            }
        }
        
    }
    
    // 1. 설문자별 답변 결과
    public void calculateParticipants(Connection connection ,Statement statement, PreparedStatement preparedStatement){
        try{
            String query = "SELECT PARTICIPANTS_UID, NAME FROM participants";
            //sql문 중간에 붙은 ? 는 밑에서 preparedStatement.setString()을 통해서 치환해줄 예정 
            String queryAnswer = "SELECT ANSWER_UID FROM RESULT WHERE PARTICIPANTS_UID = ? ORDER BY QUESTIONS_UID;";
            ResultSet resultSet = statement.executeQuery(query);
            //PreparedStatement --> Statement 의 상위호환..? 동적으로 sql문을 실행하도록 도와줌
            preparedStatement = connection.prepareStatement(queryAnswer);
            System.out.println("         Q1   Q2   Q3   Q4   Q5   Q6   Q7");
            System.out.println("이름)");
            while(resultSet.next()){
                System.out.print(resultSet.getString("NAME")+"   ");
                String PID = resultSet.getString("PARTICIPANTS_UID");
                // setString(1, PID) -> 첫번째 ? 를 PID로 대체
                preparedStatement.setString(1, PID);
                //치환된 sql문 실행!
                ResultSet resultSetAnswer = preparedStatement.executeQuery();
                while(resultSetAnswer.next()){
                    System.out.print(resultSetAnswer.getString("ANSWER_UID"));
                    System.out.print("    ");
                }
                System.out.println("");
            }
          


        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    //2. 질문 별 총 답변 수 
    public void calculateAnswers(Statement statement){
        try{
            String query = "";
            ResultSet resultSet = statement.executeQuery(query);


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
