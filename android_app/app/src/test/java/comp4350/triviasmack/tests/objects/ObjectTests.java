package comp4350.triviasmack.tests.objects;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ObjectTests {
    public static TestSuite suite;

    public static Test suite() {
        suite = new TestSuite("Business tests");
        suite.addTestSuite(QuestionTests.class);
        return suite;
    }
}