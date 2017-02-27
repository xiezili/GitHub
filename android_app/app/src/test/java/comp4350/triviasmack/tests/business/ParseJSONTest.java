package comp4350.triviasmack.tests.business;

import junit.framework.TestCase;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import comp4350.triviasmack.business.ParseJSON;
import comp4350.triviasmack.business.ServerAccessObject;
import comp4350.triviasmack.objects.Question;

import static org.junit.Assert.assertArrayEquals;

public class ParseJSONTest extends TestCase {

    public ParseJSONTest(String arg0) {
        super(arg0);
    }

    public void testParseJSON(){

        System.out.println("Testing ParseJSON: Parse Basic JSON Object");
        ArrayList<Question> q;

        try {
            JSONObject json = new JSONObject();
            JSONObject newJSON = new JSONObject();

            JSONArray result = new JSONArray();
            JSONArray options = new JSONArray();

            options.put("South America");
            options.put("Europe");
            options.put("Australia");
            options.put("Asia");

            json.put("answer", new Integer(1));
            json.put("options", options);
            json.put("question", "The Balkans are in:");

            result.put(json);
            newJSON.put("result", result);

            q = ParseJSON.parseJSONquestions(newJSON);

            assertNotNull(q);
            assertEquals(1, q.size());
            assertEquals("The Balkans are in:", q.get(0).getQuestion());

            assertEquals("South America", q.get(0).getOptions()[0]);
            assertEquals("Europe", q.get(0).getOptions()[1]);
            assertEquals("Australia", q.get(0).getOptions()[2]);
            assertEquals("Asia", q.get(0).getOptions()[3]);

            assertEquals(1, q.get(0).getAnswer());

        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }

    public void testBadFormat(){

        System.out.println("Testing ParseJSON: Bad Formated JSON");
        ArrayList<Question> q;
        JSONObject json = new JSONObject();

        try {
            json.put("Bad", "NULL");
            json.put(" Still Bad", "NULL");
            q = ParseJSON.parseJSONquestions(json);
            assertNull(q);
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }


}
