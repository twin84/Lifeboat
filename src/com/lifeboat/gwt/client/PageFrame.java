package com.lifeboat.gwt.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.*;
import com.lifeboat.gwt.client.resources.BundleCss;
import com.lifeboat.gwt.client.resources.LifeboatClientBundle;
import com.lifeboat.gwt.client.text.LifeboatConstants;
import com.lifeboat.gwt.client.widgets.TopPanelPlayerStatus;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class PageFrame extends Composite {
    private final Grid grid = new Grid(2, 1);
    private final Grid header = new Grid(1, 2);
    private TopPanelPlayerStatus topPanelPlayerStatus;

    public PageFrame() {
        grid.setWidth("100%");
        grid.setHeight("100%");
        grid.setCellSpacing(0);
        grid.setCellPadding(0);

        final HTMLTable.CellFormatter formatter = grid.getCellFormatter();
        formatter.setHeight(0, 0, "40px");
        formatter.setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
        formatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
        final Element headerElement = formatter.getElement(0, 0);
        headerElement.getStyle().setPaddingRight(5, Style.Unit.PX);
        final BundleCss css = LifeboatClientBundle.INSTANCE.css();
        headerElement.addClassName(css.header());
        header.setCellSpacing(0);
        header.setCellPadding(0);
        header.getCellFormatter().setAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
        header.getCellFormatter().setAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_TOP);
        header.setHeight("100%");
        header.setWidth("100%");
        final Label title = new Label(LifeboatConstants.INSTANCE.lifeboatTitle());
        title.addStyleName(css.headerTitle());
        title.addStyleName(css.headerColor());
        header.setWidget(0, 0, title);
        grid.setWidget(0, 0, header);

        initWidget(grid);
    }

    public void setTopPanel(TopPanelPlayerStatus topPanelPlayerStatus) {
        this.topPanelPlayerStatus = topPanelPlayerStatus;
        header.setWidget(0, 1, topPanelPlayerStatus);
    }
}
