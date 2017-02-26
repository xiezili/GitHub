package comp4350.triviasmack.application;

import comp4350.triviasmack.business.FetchQuestions;
import comp4350.triviasmack.business.ServerAccess;
import comp4350.triviasmack.business.ServerAccessDB;
import comp4350.triviasmack.business.ServerAccessStub;

public class Services {
    private static ServerAccess serverAccessService = null;

    public static ServerAccess createServerAccess(ServerAccess alternateServerAccessService) {
        if (serverAccessService == null) {
            if(alternateServerAccessService instanceof ServerAccessStub) {
                serverAccessService = alternateServerAccessService;
                serverAccessService.open();
            }
            else if(alternateServerAccessService instanceof ServerAccessDB) {
                serverAccessService = new ServerAccessDB();
                new FetchQuestions().execute(serverAccessService);
            }
        }
        return serverAccessService;
    }

    public static ServerAccess getServerAccess() {

        return serverAccessService;
    }

    public static void closeServerAccess() {
        if (serverAccessService != null) {
            serverAccessService.close();
        }
        serverAccessService = null;
    }
}
