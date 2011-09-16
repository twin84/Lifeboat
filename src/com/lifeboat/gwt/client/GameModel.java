package com.lifeboat.gwt.client;

import com.lifeboat.gwt.client.model.PlayerBasicInfo;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class GameModel {
    private PlayerBasicInfo player;

    public PlayerBasicInfo getPlayer() {
        return new PlayerBasicInfo(player);
    }

    public void setPlayer(PlayerBasicInfo playerBasicInfo) {
        player = playerBasicInfo;
    }
}
