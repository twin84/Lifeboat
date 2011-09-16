package com.lifeboat.gwt.client.event;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public interface Handler<T extends LifeboatEvent> {
    void handle(T event);
}
