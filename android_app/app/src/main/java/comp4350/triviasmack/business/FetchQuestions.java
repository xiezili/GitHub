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
import java.util.ArrayList;

import comp4350.triviasmack.objects.Question;

public class FetchQuestions extends AsyncTask<String, Void, String[]>{

    private static FetchQuestions instance = null;
    private ServerAccess serverAccess;

    public static FetchQuestions getInstance() {
        if(instance == null) {
            instance = new FetchQuestions();
        }
        return instance;
    }

    public static void destroy(){ instance = null; }

    protected ArrayList<Question> doInBackground(ServerAccess... server) {

        final String BASE_URL = "http://triviasmack.safjbugccz.us-west-2.elasticbeanstalk.com/api/android/question_data";
        String jsonQuestion = null;
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        ArrayList<Question> questions = null;
        serverAccess = server[0];

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

            questions = parseQuestion(jsonQuestion);

        } catch (Exception e) {
            e.printStackTrace();
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
        return questions;
    }

    protected void onPostExecute(ArrayList<Question> q) {
        super.onPostExecute(q);
        serverAccess.open(q);
    }

    public ArrayList<Question> parseQuestion(String jsonQuestion)
    {
        ArrayList<Question> q = null;
        JSONObject jsonObject = null, fullJSONObject;
        JSONArray array, results;
        String question = "";
        String[] options;
        int answer;

        try {
            fullJSONObject = new JSONObject(jsonQuestion);
            results = fullJSONObject.getJSONArray("result");
            q = new ArrayList<Question>();

            for(int i = 0; i < results.length(); i++) {
                jsonObject = results.getJSONObject(i);

                question = jsonObject.getString("question");

                array = jsonObject.getJSONArray("options");
                options = new String[array.length()];
                for (int j = 0; j < options.length; j++)
                    options[j] = array.get(j).toString();

                answer = jsonObject.getInt("answer");

                q.add(new Question(question, options, answer));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return q;
    }
}
