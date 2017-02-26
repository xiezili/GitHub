package comp4350.triviasmack.business;

import java.util.ArrayList;

import comp4350.triviasmack.objects.Question;

public class ServerAccessDB implements ServerAccess{

    private final ArrayList<Question> questions;

    public ServerAccessDB() {
        this.questions = new ArrayList<>();
    }

    public void open(){

    }

    public void open(ArrayList<Question> q){
        System.out.println("Opened server access");

        for(int i = 0; i < q.size(); i++)
            questions.add(q.get(i));
    }

    public void close(){
        System.out.println("Closed server access");
    }

    public ArrayList<Question> getRandomQuestions(int numQuestions){
        if(numQuestions > questions.size())
            numQuestions = questions.size()-1;
        //return new ArrayList<Question>(questions.subList(0, 2));
        return questions;
    }
}
