package comp4350.triviasmack.business;

import java.util.ArrayList;

import comp4350.triviasmack.objects.Question;

public class ServerAccessStub implements ServerAccess{

    private final ArrayList<Question> questions;

    public ServerAccessStub() {
        this.questions = new ArrayList<>();
    }

    public void open(){
        System.out.println("Opened stub server access");

        String optionsA[] = {"3", "0", "4"};
        questions.add(new Question("What is 2+2?", optionsA, 2));
        String optionsB[] = {"Sweden", "Russia"};
        questions.add(new Question("Moscow is the capitol of:", optionsB, 1));
    }

    public void close(){
        System.out.println("Closed stub server access");
    }

    public ArrayList<Question> getRandomQuestions(){
        return questions;
    }
}
