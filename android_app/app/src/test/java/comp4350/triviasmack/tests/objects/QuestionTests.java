package comp4350.triviasmack.tests.objects;

import comp4350.triviasmack.objects.Question;
import junit.framework.TestCase;

public class QuestionTests extends TestCase {

    private String[] testArray = {"3", "0", "4"};

    public QuestionTests(String arg0) {
        super(arg0);
    }

    @Override
    protected void tearDown() throws Exception {}
    @Override
    protected void setUp() throws Exception {}

    public void testBasicQuestion() {
        Question q1 = new Question("What is 2+2?", testArray, 2);

        System.out.println("\nTesting Question: BasicQuestion");

        assertEquals(q1.getQuestion(), "What is 2+2?");
        for (int i = 0; i < q1.getOptions().length; i++)
            assertEquals(testArray[i], q1.getOptions()[i]);
        assertEquals(q1.getAnswer(), 2);

        System.out.println("Finished Question: BasicQuestion");
    }

    public void testEmptyQuestion() {
        Question q1 = new Question("", new String[0], 0);

        System.out.println("\nTesting Question: EmptyQuestion");

        assertEquals(q1.getQuestion(), "");
        assertEquals(q1.getOptions().length, 0);
        assertEquals(q1.getAnswer(), 0);

        System.out.println("Finished Question: EmptyQuestion");
    }

    public void testNullQuestion() {
        Question q1 = new Question(null, null, 0);

        System.out.println("\nTesting Question: NullQuestion");

        assertNull(q1.getQuestion());
        assertNull(q1.getOptions());
        assertEquals(q1.getAnswer(), 0);

        System.out.println("Finished Question: NullQuestion");
    }
}
