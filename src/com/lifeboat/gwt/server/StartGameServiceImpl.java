package com.lifeboat.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lifeboat.gwt.client.StartGameService;
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
public class StartGameServiceImpl extends RemoteServiceServlet implements StartGameService {
    public PageInitialState connectPlayer() {
        return null;
//        final PageInitialState pageInitialState = new PageInitialState();
//        pageInitialState.setCurrentPlayer(new PlayerBasicInfo("name", "red"));
//        return pageInitialState;
    }

    public List<AvailableGame> getAvailableGames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean joinGame(PlayerBasicInfo player, String availableGameId) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createGame(PlayerBasicInfo player, CreatedGame game) {
    }
}