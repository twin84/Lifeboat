package com.lifeboat.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.lifeboat.gwt.client.model.AvailableGame;
import com.lifeboat.gwt.client.model.CreatedGame;
import com.lifeboat.gwt.client.model.PageInitialState;
import com.lifeboat.gwt.client.model.PlayerBasicInfo;

import java.util.List;

/**
 * @author Twin
 * @version 1.0
 * @since 04.09.11
 */
@RemoteServiceRelativePath("StartGameService")
public interface StartGameService extends RemoteService {
    /**
     * Utility/Convenience class.
     * Use StartGameService.App.getInstance() to access static instance of StartGameServiceAsync
     */
    public static class App {
        private static final StartGameServiceAsync ourInstance = (StartGameServiceAsync) GWT.create(StartGameService.class);

        public static StartGameServiceAsync getInstance() {
            return ourInstance;
        }
    }

    PageInitialState connectPlayer();

    List<AvailableGame> getAvailableGames();

    /**
     * @param player current player
     * @param availableGameId game ID to join
     * @return true if successfully joined
     */
    boolean joinGame(PlayerBasicInfo player, String availableGameId);

    void createGame(PlayerBasicInfo player, CreatedGame game);
}
