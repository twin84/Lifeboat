package com.lifeboat.gwt.client.model;

/**
 * @author Twin
 * @version 1.0
 * @since 28.08.11
 */
public enum Character {
    THE_KID("the Kid", 3, 9),
    LADY_LAUREN("Lady Lauren", 4, 8),
    SIR_STEPHEN("Sir Stephen", 5, 7),
    FRENCHY("Frenchy", 6, 6),
    THE_CAPTAIN("the Captain", 7, 5),
    FIRST_MATE("First Mate", 8, 4);

    private final int size;
    private final int survivalValue;
    private final String name;

    Character(String name, int size, int survivalValue) {
        this.name = name;
        this.size = size;
        this.survivalValue = survivalValue;
    }

    public int getSize() {
        return size;
    }

    public int getSurvivalValue() {
        return survivalValue;
    }

    public String getName() {
        return name;
    }
}