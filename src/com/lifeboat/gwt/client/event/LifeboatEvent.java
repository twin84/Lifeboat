package com.lifeboat.gwt.client.event;

import java.io.Serializable;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class LifeboatEvent implements Serializable {
    private final int revision;
    private boolean isAlive = true;

    public LifeboatEvent(int uniqueNumber) {
        this.revision = uniqueNumber;
    }

    void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getRevision() {
        return revision;
    }
}