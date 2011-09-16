package com.lifeboat.gwt.client.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class PageInitialState implements Serializable {

    private PlayerBasicInfo currentPlayer;
    private List<AvailableGame> availableGames;

    // current game status

    public PlayerBasicInfo getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerBasicInfo currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setAvailableGames(List<AvailableGame> availableGames) {
        this.availableGames = availableGames;
    }

    public List<AvailableGame> getAvailableGames() {
        return availableGames;
    }
}
