package com.lifeboat.gwt.client.widgets;

import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.lifeboat.gwt.client.resources.LifeboatCharactersClientBundle;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class CharacterThumbnail extends Composite {
    private final FlowPanel panel = new FlowPanel();

    public CharacterThumbnail(ImageResource character) {
        panel.setPixelSize(character.getWidth(), character.getHeight());
        Image image = AbstractImagePrototype.create(LifeboatCharactersClientBundle.Border.getBorder(character)).createImage();
        image.getElement().getStyle().setPosition(Style.Position.ABSOLUTE);
        panel.add(image);
        panel.add(AbstractImagePrototype.create(character).createImage());
        initWidget(panel);
    }
}
