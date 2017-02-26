package comp4350.triviasmack.business;

import java.util.ArrayList;

import comp4350.triviasmack.objects.Question;

public interface ServerAccess {
    void open();

    void open(ArrayList<Question> q);

    void close();

    ArrayList<Question> getRandomQuestions();
}
