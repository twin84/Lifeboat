package com.lifeboat.gwt.client.event;

import com.lifeboat.gwt.client.model.Character;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class TextMessageEvent extends LifeboatEvent {
    private final String messageText;
    private final Character characterFrom;

    public TextMessageEvent(int uniqueNumber, Character characterFrom, String messageText) {
        super(uniqueNumber);
        this.messageText = messageText;
        this.characterFrom = characterFrom;
    }

    public String getMessageText() {
        return messageText;
    }

    public Character getCharacterFrom() {
        return characterFrom;
    }
}
