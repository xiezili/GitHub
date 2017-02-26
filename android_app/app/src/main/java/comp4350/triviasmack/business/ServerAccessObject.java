package comp4350.triviasmack.business;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;

import comp4350.triviasmack.objects.Question;

public class ServerAccessObject implements ServerAccess {

    private URL baseUrl;
    private BufferedReader serverReader;

    public ServerAccessObject(int numQuestions){
        try {
            baseUrl
            = new URL("http://trivia-env.vwcgzcxeet.us-west-2.elasticbeanstalk.com/api/android/question_data/" +
                      "" + numQuestions);
        }
        catch (java.net.MalformedURLException e){}
    }

    public void open(){}

    public void close(){}

    public ArrayList<Question> getRandomQuestions(){
        JSONObject result = null;
        BackgroundTask serverTask;

        serverTask = new BackgroundTask();

        try {
            result = serverTask.execute(baseUrl).get();
        }
        catch (java.lang.InterruptedException e){}
        catch (java.util.concurrent.ExecutionException e){}

        return parseQuestions(result);
    }


    private ArrayList<Question> parseQuestions(JSONObject jsonResult)
    {
        Question questionObj;
        JSONObject jsonQuestionObject;
        JSONArray jsonQuestions, jsonOptions;
        String question;
        String[] options;
        int answer;
        ArrayList<Question> questions;

        questions = new ArrayList<>();

        try {

            jsonQuestions = jsonResult.getJSONArray("result");

            for(int i = 0; i < jsonQuestions.length(); i++){

                jsonQuestionObject = (JSONObject)jsonQuestions.get(i);

                question = jsonQuestionObject.getString("question");
                jsonOptions = jsonQuestionObject.getJSONArray("options");

                options = new String[jsonOptions.length()];

                for(int j = 0; j < jsonOptions.length(); j++) {
                    options[j] = jsonOptions.get(j).toString();
                }

                answer = jsonQuestionObject.getInt("answer");

                questionObj = new Question(question, options, answer);
                questions.add(questionObj);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}
