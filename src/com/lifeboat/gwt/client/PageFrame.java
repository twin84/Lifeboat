package com.lifeboat.gwt.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.*;
import com.lifeboat.gwt.client.resources.BundleCss;
import com.lifeboat.gwt.client.resources.LifeboatClientBundle;
import com.lifeboat.gwt.client.text.LifeboatConstants;
import com.lifeboat.gwt.client.widgets.EnterNamePanel;
import com.lifeboat.gwt.client.widgets.TopPanelPlayerStatus;

/**
 * @author Anton Bliznets
 * @since 14.09.11
 */
public class PageFrame extends Composite {
    private static final int ROW_HEADER = 0;
    private static final int ROW_CONTENT = 1;

    private final Grid grid = new Grid(2, 1);
    private final Grid header = new Grid(1, 2);
    private TopPanelPlayerStatus topPanelPlayerStatus;

    public PageFrame() {
        grid.setWidth("100%");
        grid.setHeight("100%");
        grid.setCellSpacing(0);
        grid.setCellPadding(0);

        final HTMLTable.CellFormatter formatter = grid.getCellFormatter();
        formatter.setHeight(ROW_HEADER, 0, "40px");
        formatter.setVerticalAlignment(ROW_HEADER, 0, HasVerticalAlignment.ALIGN_TOP);
        formatter.setHorizontalAlignment(ROW_HEADER, 0, HasHorizontalAlignment.ALIGN_RIGHT);
        final Element headerElement = formatter.getElement(ROW_HEADER, 0);
        headerElement.getStyle().setPaddingRight(5, Style.Unit.PX);
        final BundleCss css = LifeboatClientBundle.INSTANCE.css();
        headerElement.addClassName(css.header());
        header.setCellSpacing(0);
        header.setCellPadding(0);
        header.getCellFormatter().setAlignment(ROW_HEADER, 0, HasHorizontalAlignment.ALIGN_LEFT, HasVerticalAlignment.ALIGN_TOP);
        header.getCellFormatter().setAlignment(ROW_HEADER, 1, HasHorizontalAlignment.ALIGN_RIGHT, HasVerticalAlignment.ALIGN_TOP);
        header.setHeight("100%");
        header.setWidth("100%");
        final Label title = new Label(LifeboatConstants.INSTANCE.lifeboatTitle());
        title.addStyleName(css.headerTitle());
        title.addStyleName(css.headerColor());
        header.setWidget(ROW_HEADER, 0, title);
        grid.setWidget(ROW_HEADER, 0, header);

        formatter.setAlignment(ROW_CONTENT, 0, HasHorizontalAlignment.ALIGN_CENTER, HasVerticalAlignment.ALIGN_MIDDLE);

        initWidget(grid);
    }

    public void setTopPanel(TopPanelPlayerStatus topPanelPlayerStatus) {
        this.topPanelPlayerStatus = topPanelPlayerStatus;
        header.setWidget(ROW_HEADER, 1, topPanelPlayerStatus);
    }

    public void setContent(Widget content) {
        grid.setWidget(ROW_CONTENT, 0, content);
    }
}
