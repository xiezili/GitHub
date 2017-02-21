package comp4350.triviasmack.business;

import comp4350.triviasmack.objects.Question;

public class GameController {

    private static GameController instance = null;
    private final static int maxQuestions = 2;

    private Question questions[];
    private int questionCount;
    private Question currQuestion;
    private int score;

    protected GameController(){
        questions = null;
        questionCount = -1;
        currQuestion = null;
        score = -1;
    }

    public static GameController getInstance() {
        if(instance == null) {
            instance = new GameController();
        }
        return instance;
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

    public boolean evaluateAnswer(String playersAnswer){
        String answer;
        boolean result;

        result = false;
        answer = currQuestion.options[currQuestion.answer];

        if (playersAnswer.equalsIgnoreCase(answer)){
            result = true;
        }
        return result;
    }

    public void increaseScore(){ instance.score++; }

    public boolean finished(){
        return maxQuestions == questionCount;
    }
}
