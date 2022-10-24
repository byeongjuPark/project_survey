import java.sql.*;
import java.util.ArrayList;

public class Result {
    ArrayList<String> list = null;
    // 0. 초기 출력
    public void printCalMenu(){
        System.out.println("------------------------------------------------");
        System.out.println("1. 설문자별 답변 결과    | 2. 질문 별 총 답변 수");
        System.out.println("------------------------------------------------");
    }
    
    // 1. 설문자별 답변 결과
    public void calculateParticipants(Statement statement){
        
        try{
            list = new ArrayList<>();


            String query = "SELECT QUESTIONS_UID ,NAME, answers.ANSWER_UID FROM result INNER JOIN participants ON result.PARTICIPANTS_UID = participants.PARTICIPANTS_UID INNER JOIN answers ON result.ANSWER_UID = answers.ANSWER_UID ORDER BY QUESTIONS_UID;";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                String name = resultSet.getString("NAME");
                String answer_uid = resultSet.getString("ANSWER_UID");
                System.out.print(name+" ");
                System.out.print(answer_uid+" ");
                System.out.println();
                
                
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    // 2. 질문 별 총 답변 수 
    // public void calculateAnswers(Statement statement){
    //     try{
    //         String query = "";
    //         ResultSet resultSet = statement.executeQuery(query);


    //     }catch(SQLException e){
    //         e.printStackTrace();
    //     }

    // }

}
