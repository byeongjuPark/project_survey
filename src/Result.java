import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Result {
    Scanner sc = new Scanner(System.in);
    class user{
        String uid;
        String name;
        
    }
    ArrayList<String> list = null;
    // 0. 초기 출력
    public void printCalMenu(Statement statement){

        String input;
        while(true){
            System.out.println("------------------------------------------------");
            System.out.println("1. 설문자별 답변 결과    | 2. 질문 별 총 답변 수");
            System.out.println("------------------------------------------------");
            System.out.println(">>");
            input = sc.next();
            if(input.equals("1")){
                calculateAnswers(statement);
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
    public void calculateParticipants(Statement statement){
        
        try{
            list = new ArrayList<>();

            String query = "SELECT QUESTIONS_UID, participants.PARTICIPANTS_UID, NAME, answers.ANSWER_UID FROM result INNER JOIN participants ON result.PARTICIPANTS_UID = participants.PARTICIPANTS_UID INNER JOIN answers ON result.ANSWER_UID = answers.ANSWER_UID ORDER BY NAME, QUESTIONS_UID;";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                
                

                //아무것도 모르겠음
                
                
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
