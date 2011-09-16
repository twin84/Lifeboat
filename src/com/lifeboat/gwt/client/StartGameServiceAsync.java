package com.lifeboat.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
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
public interface StartGameServiceAsync {
    void connectPlayer(AsyncCallback<PageInitialState> async);

    void joinGame(PlayerBasicInfo player, String availableGameId, AsyncCallback<Boolean> async);

    void createGame(PlayerBasicInfo player, CreatedGame game, AsyncCallback<Void> async);

    void getAvailableGames(AsyncCallback<List<AvailableGame>> async);
}
