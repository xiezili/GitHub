package comp4350.triviasmack;

import junit.framework.Test;
import junit.framework.TestSuite;

import comp4350.triviasmack.tests.business.BusinessTests;

public class RunUnitTests {
    public static TestSuite suite;

    public static Test suite() {
        suite = new TestSuite("Unit tests");
        suite.addTest(BusinessTests.suite());
        return suite;
    }
}