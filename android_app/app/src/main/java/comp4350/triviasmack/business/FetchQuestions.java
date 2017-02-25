package comp4350.triviasmack.business;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchQuestions extends AsyncTask<String, Void, String[]>{

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
}
