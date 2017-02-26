package comp4350.triviasmack.application;


import comp4350.triviasmack.business.ServerAccessDB;
import comp4350.triviasmack.business.ServerAccessStub;

public class Main {

    public static void main(String[] args) {
        startUp();

        shutDown();

        System.out.println("All done");
    }

    public static void startUp() {
       // Services.createServerAccess(new ServerAccessDB());
        Services.createServerAccess(new ServerAccessStub());
    }

    public static void shutDown() {
        Services.closeServerAccess();
    }
}
