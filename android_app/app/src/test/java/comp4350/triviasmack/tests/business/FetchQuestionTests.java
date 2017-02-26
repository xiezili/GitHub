package comp4350.triviasmack.tests.business;

import junit.framework.TestCase;


import org.json.JSONArray;
import org.json.JSONObject;

import comp4350.triviasmack.business.FetchQuestions;
import comp4350.triviasmack.objects.Question;

import static org.junit.Assert.assertArrayEquals;

public class FetchQuestionTests extends TestCase {

    private String str = "{\"question\": What is 2+2?, \"options\": [3,0,4,],\"answer\": 2,}";
    private String[] testArray = {"3", "0", "4"};
    private FetchQuestions dummyFetchQuestions;

    @Override
    protected void setUp() throws Exception {
        dummyFetchQuestions = FetchQuestions.getInstance();
    }

    public FetchQuestionTests(String arg0) {
        super(arg0);
    }

    @Override
    protected void tearDown() throws Exception {
        FetchQuestions.destroy();
    }

    /*public void testBasicJSON(){
        System.out.println("\nTesting FetchQuestion: ParseQuestion");
        Question q;

        q = dummyFetchQuestions.parseQuestion(str);
        assertNotNull(q);

        assertEquals(q.getQuestion(), "What is 2+2?");
        assertEquals(q.getAnswer(), 2);
        assertArrayEquals(testArray, q.getOptions());

        System.out.println("Finished FetchQuestion: ParseQuestion");
    }*/
}
