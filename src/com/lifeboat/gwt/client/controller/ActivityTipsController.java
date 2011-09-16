package com.lifeboat.gwt.client.controller;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.lifeboat.gwt.client.Util;
import com.lifeboat.gwt.client.model.Character;
import com.lifeboat.gwt.client.event.Handler;
import com.lifeboat.gwt.client.event.TextMessageEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Bliznets
 * @since 09.09.11
 */
public class ActivityTipsController implements Handler<TextMessageEvent> {
//    private final List<Canvas> shownTips = new ArrayList<Canvas>();
    private Map<Character, String> characterColors;

    public void setColors(Map<Character, String> characterColors) {
        this.characterColors = characterColors;
    }

    public void handle(TextMessageEvent event) {
        if (Util.isEmpty(event.getMessageText())) {
            return;
        }
        final Element element = DOM.createSpan();
        final Element name = DOM.createSpan();
        final Element text = DOM.createSpan();
        text.setInnerText(event.getMessageText());
        if (event.getCharacterFrom() != null) {
            name.setInnerText(event.getCharacterFrom().getName() + ": ");
            final String color = characterColors.get(event.getCharacterFrom());
            if (color != null) {
                name.getStyle().setColor(color);
                name.getStyle().setFontWeight(Style.FontWeight.BOLD);
            }
        }
        element.appendChild(name);
        element.appendChild(text);
        show(new HTML(element) {
        }.toString());
    }

    private void show(String contents) {
        final int width = 250;
/*
        final Canvas canvas = new Canvas();
        canvas.setBackgroundColor("fff");
        canvas.setBorder("1px solid #ddd");
        canvas.setShowShadow(true);
        canvas.setShadowOffset(5);
        canvas.setPadding(5);
        canvas.setContents(contents);
        canvas.setWidth(width);
        canvas.setPosition(Positioning.ABSOLUTE);
        canvas.moveTo(Window.getClientWidth() - width - 10, Window.getClientHeight() - 200);
        canvas.animateShow(AnimationEffect.SLIDE);
*/
    }
}