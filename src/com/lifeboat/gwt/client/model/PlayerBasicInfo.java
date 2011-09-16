package com.lifeboat.gwt.client.model;

import java.io.Serializable;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class PlayerBasicInfo implements Serializable {

    private String playerName;
    private String playerColor;

    public PlayerBasicInfo() {
    }

    public PlayerBasicInfo(String playerName, String playerColor) {
        this.playerName = playerName;
        this.playerColor = playerColor;
    }

    public PlayerBasicInfo(PlayerBasicInfo player) {
        if (player != null) {
            playerName = player.getPlayerName();
            playerColor = player.getPlayerColor();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}