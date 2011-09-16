package com.lifeboat;

import com.lifeboat.gwt.client.model.Character;

import java.util.List;

/**
 * @author Twin
 * @version 1.0
 * @since 28.08.11
 */
public class Navigation {
    private List<Character> overboardCharacters;
    private List<com.lifeboat.gwt.client.model.Character> thirstyCharacters;
    private boolean isThirstyFighters;
    private boolean isThirstyRowers;

    /**
     * null if no bird event. True to increment birds counter, false to decrement birds counter
     */
    private Boolean isBirdPresent;

    public List<Character> getOverboardCharacters() {
        return overboardCharacters;
    }

    public List<Character> getThirstyCharacters() {
        return thirstyCharacters;
    }

    public boolean isThirstyFighters() {
        return isThirstyFighters;
    }

    public boolean isThirstyRowers() {
        return isThirstyRowers;
    }

    public Boolean getBirdPresent() {
        return isBirdPresent;
    }
}