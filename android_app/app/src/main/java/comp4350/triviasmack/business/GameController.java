package comp4350.triviasmack.business;

import java.util.ArrayList;

import comp4350.triviasmack.application.Services;
import comp4350.triviasmack.objects.Question;

public class GameController {

    private static GameController instance = null;
    private final static int maxQuestions = 2;

    private ArrayList<Question> questions;
    private int questionCount;
    private Question currQuestion;
    private int score;
    private boolean started;
    private ServerAccess serverAccess;

    protected GameController(){
        questions = null;
        questionCount = -1;
        currQuestion = null;
        score = -1;
        serverAccess = Services.getServerAccess();
    }

    public static GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    private ArrayList<Question> getQuestions(){
        return serverAccess.getRandomQuestions();
    }

    public int getScore(){ return score; }

    public void start(){
        questionCount = 0;
        score = 0;
        questions = getQuestions();
        started = true;
    }

    public Question getNextQuestion(){
        if (questionCount == maxQuestions) {
            currQuestion = null;
        }
        else {
            currQuestion = questions.get(questionCount);
            questionCount++;
        }

        return currQuestion;
    }

    public boolean evaluateAnswer(String playersAnswer){
        boolean result = false;
        String answer = currQuestion.options[currQuestion.answer];

        if (playersAnswer.equalsIgnoreCase(answer)){
            result = true;
        }
        return result;
    }

    public void increaseScore(){ score++; }

    public boolean isStarted(){ return started; }

    public boolean finished(){
        return maxQuestions == questionCount;
    }

    public static void destroy(){ instance = null; }
}
