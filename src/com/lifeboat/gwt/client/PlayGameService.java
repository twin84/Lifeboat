package com.lifeboat.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
@RemoteServiceRelativePath("PlayGameService")
public interface PlayGameService extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use GameRPCService.App.getInstance() to access static instance of GameRPCServiceAsync
     */
    public static class App {
        private static final PlayGameServiceAsync ourInstance = (PlayGameServiceAsync) GWT.create(PlayGameService.class);

        public static PlayGameServiceAsync getInstance() {
            return ourInstance;
        }
    }

    void foo();



}
