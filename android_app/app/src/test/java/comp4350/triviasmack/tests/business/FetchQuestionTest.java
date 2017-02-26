package comp4350.triviasmack.tests.business;

import junit.framework.TestCase;


import org.json.JSONArray;
import org.json.JSONObject;

import comp4350.triviasmack.business.FetchQuestions;
import comp4350.triviasmack.objects.Question;

public class FetchQuestionTest extends TestCase {

    public FetchQuestionTest(String arg0) {
        super(arg0);
    }

    private String str = "{\n" +
            "\t\"question\": What is 2+2?,\n" +
            "\t\"options\": [\n" +
            "\t\t\"3\",\n" +
            "\t\t0,\n" +
            "\t\t4,\n" +
            "\t],\n" +
            "\t\"answer\": 2,\n" +
            "}";

    private String[] testArray = {"3", "0", "4"};
    private FetchQuestions dummyFetchQuestions;

    @Override
    protected void setUp() throws Exception {
        dummyFetchQuestions = FetchQuestions.getInstance();
    }

    @Override
    protected void tearDown() throws Exception {
        FetchQuestions.destroy();
    }

    public void testBasicJSON(){
        System.out.println("Testing FetchQuestion: ParseQuestion");
        Question q;

        q = dummyFetchQuestions.parseQuestion(str);
        assertNotNull(q);

        assertEquals(q.getQuestion(), "What is 2+2?");
        assertEquals(q.getAnswer(), 2);
        for (int i = 0; i < q.getOptions().length; i++)
            assertEquals(testArray[i], q.getOptions()[i]);
    }

    public void testSingleton(){
        System.out.println("Testing GameController: Singleton");

        FetchQuestions first = FetchQuestions.getInstance();
        FetchQuestions second = FetchQuestions.getInstance();
        assertEquals(first, second);
    }

    public void testWrongValue(){

        System.out.println("Testing FetchQuestion: ErrorHandling");

        boolean fail = true;

        try {
            JSONObject obj = new JSONObject(str);

            JSONArray jsonArray = obj.getJSONArray("options");
            assertNotNull(jsonArray);

            for (int i = 0; i < jsonArray.length(); i++)
                assertEquals(testArray[i], jsonArray.get(i).toString());

            int number = obj.getInt("umber");
            fail = false;
        }
        catch(Exception e)
        {
        }
        assertTrue(fail);
    }
}
