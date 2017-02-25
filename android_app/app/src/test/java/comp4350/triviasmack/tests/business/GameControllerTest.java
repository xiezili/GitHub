package comp4350.triviasmack.tests.business;

import junit.framework.TestCase;

import comp4350.triviasmack.application.Services;
import comp4350.triviasmack.business.GameController;
import comp4350.triviasmack.business.ServerAccessStub;

public class GameControllerTest extends TestCase {

    private GameController dummyGameController;

    public GameControllerTest(String arg0) {
        super(arg0);
    }

    @Override
    protected void setUp() throws Exception {
        Services.closeServerAccess();
        Services.createServerAccess(new ServerAccessStub());
        dummyGameController = GameController.getInstance();
    }

    @Override
    protected void tearDown() throws Exception {
        Services.closeServerAccess();
        GameController.destroy();
    }

    public void testSingleton(){
        System.out.println("\nTesting GameController: Singleton");
        GameController first = GameController.getInstance();
        GameController second = GameController.getInstance();
        assertEquals(first, second);
    }

    public void testStart(){
        System.out.println("\nTesting GameController: Start");
        assertFalse(dummyGameController.isStarted());
        dummyGameController.start();
        assertTrue(dummyGameController.isStarted());
    }

    public void testIncreaseScore(){
        System.out.println("\nTesting GameController: IncreaseScore");
        dummyGameController.start();
        assertEquals(0, dummyGameController.getScore());
        dummyGameController.increaseScore();
        assertEquals(1, dummyGameController.getScore());
    }

    public void testGetQuestion(){
        System.out.println("\nTesting GameController: GetQuestion");
        dummyGameController.start();
    }
}
