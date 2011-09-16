package com.lifeboat;

import com.lifeboat.gwt.client.model.Character;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Twin
 * @version 1.0
 * @since 28.08.11
 */
public class Player {
    private final Character playerCharacter;
    private final Character loveCharacter;
    private final Character hateCharacter;

    private int sizeCurrent;
    private boolean unconscious;
    private final List<Provision> provisionsInHands = new ArrayList<Provision>();
    private final List<Provision> provisionsHidden = new ArrayList<Provision>();

    public Player(Character playerCharacter, com.lifeboat.gwt.client.model.Character loveCharacter, Character hateCharacter) {
        this.playerCharacter = playerCharacter;
        this.loveCharacter = loveCharacter;
        this.hateCharacter = hateCharacter;
        sizeCurrent = playerCharacter.getSize();
        unconscious = false; //just for info
    }
}
