package comp4350.triviasmack.objects;

import java.io.Serializable;

public class Question implements Serializable{

    public String question;
    public String[] options;
    public int answer;

    public Question(String question, String[] options, int answer)
    {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }
}
