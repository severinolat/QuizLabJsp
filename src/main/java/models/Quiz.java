package models;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int current;
    private int score;

    public Quiz(){
        this.questions = Arrays.asList(
                new Question("3, 1, 4, 1, 5", "9"),
                new Question("1, 1, 2, 3, 5", "8"),
                new Question("1, 4, 9, 16, 25", "36"),
                new Question("2, 3, 5, 7, 11", "13"),
                new Question("1, 2, 4, 8, 16", "32")
        );
    }

    public String getNextQuestion(){
        if(current >= questions.size()){
            return null;
        }else{
            return this.questions.get(current++).getQuestin();
        }
    }
    public void checkAnswer(String answer){
        int temp = current - 1;
        boolean result = this.questions.get(temp).checkAnswer(answer);
        if(result) this.score++;
    }

    public boolean lastQuestion(){
        return this.current == questions.size();
    }

    public int getScore(){
        return score;
    }

    public int getTotalScore(){
        return this.questions.size();
    }
}
