package com.lifeboat.gwt.client.model;

import java.io.Serializable;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class AvailableGame implements Serializable {
    private PlayerBasicInfo hostPlayer;
    private int playersCount;

    public PlayerBasicInfo getHostPlayer() {
        return hostPlayer;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setHostPlayer(PlayerBasicInfo hostPlayer) {
        this.hostPlayer = hostPlayer;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }
}
