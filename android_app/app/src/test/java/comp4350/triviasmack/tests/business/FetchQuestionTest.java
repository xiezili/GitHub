package comp4350.triviasmack.tests.business;

import junit.framework.TestCase;


import org.json.JSONArray;
import org.json.JSONObject;

import comp4350.triviasmack.business.FetchQuestions;
import comp4350.triviasmack.objects.Question;

import static org.junit.Assert.assertArrayEquals;

<<<<<<< HEAD:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTests.java
public class FetchQuestionTests extends TestCase {

    private String str = "{\"question\": What is 2+2?, \"options\": [3,0,4,],\"answer\": 2,}";
=======
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

>>>>>>> fd8d9748c32e495909a4956e7b39e7402633e7cc:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTest.java
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

<<<<<<< HEAD:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTests.java
    /*public void testBasicJSON(){
        System.out.println("\nTesting FetchQuestion: ParseQuestion");
        Question q;
=======
    public void testBasicJSON(){
        System.out.println("Testing FetchQuestion: ParseQuestion");
        Question questionObj;

        questionObj = dummyFetchQuestions.parseQuestion(str);
        assertNotNull(questionObj);
>>>>>>> fd8d9748c32e495909a4956e7b39e7402633e7cc:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTest.java

        assertEquals(questionObj.getQuestion(), "What is 2+2?");
        assertEquals(questionObj.getAnswer(), 2);
        assertArrayEquals(testArray, questionObj.getOptions());
    }

<<<<<<< HEAD:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTests.java
        assertEquals(q.getQuestion(), "What is 2+2?");
        assertEquals(q.getAnswer(), 2);
        assertArrayEquals(testArray, q.getOptions());

        System.out.println("Finished FetchQuestion: ParseQuestion");
    }*/
=======
    public void testSingleton(){
        System.out.println("Testing GameController: Singleton");

        FetchQuestions first = FetchQuestions.getInstance();
        FetchQuestions second = FetchQuestions.getInstance();
        assertEquals(first, second);
    }

    public void testWrongValue(){
        System.out.println("Testing FetchQuestion: ErrorHandling");

        JSONObject jsonObj;
        JSONArray jsonArray;

        try {
            jsonObj = new JSONObject(str);

            jsonArray = jsonObj.getJSONArray("options");
            assertNotNull(jsonArray);

            for (int i = 0; i < jsonArray.length(); i++)
                assertEquals(testArray[i], jsonArray.get(i).toString());

            jsonObj.getInt("umber");
            fail("Expected a NullPointerException");
        }
        catch(Exception e) {}
    }
>>>>>>> fd8d9748c32e495909a4956e7b39e7402633e7cc:android_app/app/src/test/java/comp4350/triviasmack/tests/business/FetchQuestionTest.java
}
