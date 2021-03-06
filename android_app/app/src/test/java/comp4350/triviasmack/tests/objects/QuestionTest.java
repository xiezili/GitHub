package comp4350.triviasmack.tests.objects;

import junit.framework.TestCase;

import comp4350.triviasmack.objects.Question;

import static org.junit.Assert.assertArrayEquals;

public class QuestionTest extends TestCase {

    private String question;
    private String[] options;
    private int answer;
    private Question questionObj;

    public QuestionTest(String arg0) {
        super(arg0);
    }

    @Override
    protected void setUp() throws Exception {
        question = "What's my favorite color?";
        options = new String[]{"blue", "green", "red"};
        answer = 0;
        questionObj = new Question(question, options, answer);
    }

    @Override
    protected void tearDown() throws Exception {
        questionObj = null;
    }

    public void testConstructor() {
        System.out.println("Testing Question: Constructor");

        assertNotNull(questionObj);
        assertEquals(question, questionObj.getQuestion());
        assertArrayEquals(options, questionObj.getOptions());
        assertEquals(answer, questionObj.getAnswer());
    }

    public void testAccessors() {
        System.out.println("Testing Question: Mutators");

        assertEquals(answer, questionObj.getAnswer());
        assertEquals(options, questionObj.getOptions());
        assertEquals(question, questionObj.getQuestion());
    }

    public void testEmptyQuestion() {
        System.out.println("Testing Question: EmptyQuestion");

        Question q1 = new Question("", new String[0], 0);

        assertEquals(q1.getQuestion(), "");
        assertEquals(q1.getOptions().length, 0);
        assertEquals(q1.getAnswer(), 0);
    }

    public void testFailure() {
        System.out.println("Testing Question: Invalid Args");

        try{
            new Question(null, null, -1);
            fail("Expected a NullPointerException");
        } catch (NullPointerException ignored) {}
    }
}
