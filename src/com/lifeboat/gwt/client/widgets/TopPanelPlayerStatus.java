package com.lifeboat.gwt.client.widgets;

import com.google.gwt.dom.client.Style;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.lifeboat.gwt.client.model.PlayerBasicInfo;
import com.lifeboat.gwt.client.resources.BundleCss;
import com.lifeboat.gwt.client.resources.LifeboatClientBundle;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class TopPanelPlayerStatus extends Composite {

    public TopPanelPlayerStatus(ImageResource character, PlayerBasicInfo playerBasicInfo) {
        final HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        hPanel.setSpacing(5);

        final BundleCss css = LifeboatClientBundle.INSTANCE.css();

        hPanel.add(new CharacterThumbnail(character));
        final Label name = new Label(playerBasicInfo.getPlayerName());
        name.addStyleName(css.headerColor());
        hPanel.add(name);

        final Label label = new Label();
        label.setPixelSize(20, 20);
        label.getElement().getStyle().setBackgroundColor(playerBasicInfo.getPlayerColor());

        label.addStyleName(css.headerBorder());
        hPanel.add(label);

        initWidget(hPanel);
    }
}
