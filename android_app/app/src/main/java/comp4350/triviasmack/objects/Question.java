package comp4350.triviasmack.objects;

import java.io.Serializable;

public class Question implements Serializable{

    private String question;
    private String[] options;
    private int answer;

    public Question(String question, String[] options, int answer)
    {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion(){
        return question;

    }

    public int getAnswer(){
        return answer;
    }

    public String[] getOptions(){
        return options;
    }
}
