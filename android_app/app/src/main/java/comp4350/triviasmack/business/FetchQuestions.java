package comp4350.triviasmack.business;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import comp4350.triviasmack.objects.Question;

public class FetchQuestions extends AsyncTask<String, Void, String[]>{
    private static FetchQuestions instance = null;

    public static FetchQuestions getInstance() {
        if(instance == null) {
            instance = new FetchQuestions();
        }
        return instance;
    }

    public static void destroy(){ instance = null; }

    protected String[] doInBackground(String... params) {

        final String BASE_URL = "triviasmack.safjbugccz.us-west-2.elasticbeanstalk.com/api/android/question_data";
        String jsonQuestion = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String[] questions;

        try {
            URL url = new URL(BASE_URL);

            //create request to flask
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            //create input stream for json string
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null)
                return null;
            reader = new BufferedReader(new InputStreamReader((inputStream)));

            String line;
            while ((line = reader.readLine()) != null)
                buffer.append(line + "\n");

            if (buffer.length() == 0)
                return null;
            jsonQuestion = buffer.toString();
            Log.v("Testing output", jsonQuestion);



        } catch (Exception e) {
            System.out.println("Exception");

        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (reader != null) {
                try {
                    reader.close();

                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing Stream", e);
                }
            }
        }

        return null;
    }

    protected void onPostExecute(String[] strings) {
        super.onPostExecute(strings);

    }

    public Question parseQuestion(String jsonQuestion)
    {
        Question q = null;
        JSONObject jsonObject = null;
        String question = "";
        String[] options;
        int answer;

        try {
            jsonObject = new JSONObject(jsonQuestion);

            question = jsonObject.getString("question");

            JSONArray array = jsonObject.getJSONArray("options");
            options = new String[array.length()];
            for(int i = 0; i < options.length; i++)
                options[i] = array.get(i).toString();

            answer = jsonObject.getInt("answer");

            q = new Question(question, options, answer);
        }
        catch(Exception e) {
            System.out.println("HERE FAIL");
            e.printStackTrace();
        }

        return q;
    }
}
