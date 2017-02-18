package comp4350.triviasmack.business;

import java.io.Serializable;

import comp4350.triviasmack.objects.Question;

public class GameController implements Serializable {

    private int maxQuestions;
    private Question questions[];
    private int questionCount;
    private Question currQuestion;
    private int score;

    public GameController(int maxQuestions){
        this.maxQuestions = maxQuestions;
        questions = null;
        questionCount = -1;
        currQuestion = null;
        score = -1;
    }

    private Question[] getQuestions(){
        Question result[] = new Question[2];
        String optionsA[] = {"3", "0", "4"};
        result[0] = new Question("What is 2+2?", optionsA, 2);
        String optionsB[] = {"Sweden", "Russia"};
        result[1] = new Question("Moscow is the capitol of:", optionsB, 1);
        return result;
    }

    public int getScore(){ return score; }

    public void start(){
        questionCount = 0;
        score = 0;
        questions = getQuestions();
    }

    public Question getNextQuestion(){
        if (questionCount == maxQuestions) {
            currQuestion = null;
        }
        else {
            currQuestion = questions[questionCount];
            questionCount++;
        }

        return currQuestion;
    }

    public void updateScore(int answerIndex){
        if (answerIndex == currQuestion.answer){
            score++;
        }
    }

    public boolean finished(){
        return maxQuestions == questionCount;
    }
}
