package com.lifeboat.gwt.client.widgets;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.tips.QuickTip;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;
import com.lifeboat.gwt.client.model.AvailableGame;
import com.lifeboat.gwt.client.text.LifeboatConstants;

import java.util.*;

/**
 * @author Anton Bliznets
 * @since 16.09.11
 */
public class AvailableGamesPanel extends LayoutContainer {
    private static final String ROW_NUMBER = LifeboatConstants.INSTANCE.avGameNum();
    private static final String PLAYER_NAME = LifeboatConstants.INSTANCE.avGamePlayerName();
    private static final String PLAYERS_COUNT = LifeboatConstants.INSTANCE.avGamePlayersCount();

    private final List<BaseModelData> data = new ArrayList<BaseModelData>();

    public AvailableGamesPanel(List<AvailableGame> availableGames) {
        refreshData(availableGames);
    }

    public void refreshData(List<AvailableGame> availableGames) {
        data.clear();
        int num = 1;
        for (AvailableGame game : availableGames) {
            data.add(new BaseModelData(num++, game));
        }
        if (isAttached()) {
            render(DOM.getParent(getElement()));
        }
    }

    @Override
    protected void onRender(Element parent, int index) {
        super.onRender(parent, index);
        setLayout(new FlowLayout(10));
        getAriaSupport().setPresentation(true);

        List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
        configs.add(createColumn(ROW_NUMBER, HorizontalAlignment.RIGHT, 30));
        configs.add(createColumn(PLAYER_NAME, HorizontalAlignment.LEFT, 200));
        configs.add(createColumn(PLAYERS_COUNT, HorizontalAlignment.RIGHT, 80));

        ListStore<BaseModelData> store = new ListStore<BaseModelData>();
        store.add(data);

        ColumnModel cm = new ColumnModel(configs);

        ContentPanel cp = new ContentPanel();
        cp.setBodyBorder(true);
//    cp.setIcon(Resources.ICONS.table());
        cp.setHeading("Basic Grid");
        cp.setButtonAlign(HorizontalAlignment.CENTER);
        cp.setLayout(new FitLayout());
        cp.getHeader().setIconAltText("Grid Icon");
        cp.setSize(330, 600);

        final Grid<BaseModelData> grid = new Grid<BaseModelData>(store, cm);
        grid.setStyleAttribute("borderTop", "none");
        grid.setAutoExpandColumn(PLAYER_NAME);
        grid.setBorders(false);
        grid.setStripeRows(true);
        grid.setColumnLines(true);
        grid.setColumnReordering(true);
        grid.getAriaSupport().setLabelledBy(cp.getHeader().getId() + "-label");
        cp.add(grid);


        add(cp);

        // needed to enable quicktips (qtitle for the heading and qtip for the
        // content) that are setup in the change GridCellRenderer
        new QuickTip(grid);
    }

    private ColumnConfig createColumn(String col, HorizontalAlignment align, int width) {
        final ColumnConfig column = new ColumnConfig();
        column.setHeader(col);
        column.setId(col);
        column.setAlignment(align);
        if (width > 0) {
            column.setWidth(width);
        }
        return column;
    }

    private static class BaseModelData implements ModelData {
        private Map<String, Object> props = new HashMap<String, Object>();
        private final AvailableGame game;

        private BaseModelData(int row, AvailableGame game) {
            this.game = game;
            props.put(ROW_NUMBER, row);
            props.put(PLAYER_NAME, game.getHostPlayer());
            props.put(PLAYERS_COUNT, game.getPlayersCount());
        }

        public <X> X get(String property) {
            if (PLAYER_NAME.equals(property)) {
                final Label html = new Label(game.getHostPlayer().getPlayerName());
                html.getElement().getStyle().setColor(game.getHostPlayer().getPlayerColor());
                return (X) html;
            }
            return (X) props.get(property);
        }

        public Map<String, Object> getProperties() {
            return props;
        }

        public Collection<String> getPropertyNames() {
            return Arrays.asList(ROW_NUMBER, PLAYER_NAME, PLAYERS_COUNT);
        }

        public <X> X remove(String property) {
            return (X) props.remove(property);
        }

        public <X> X set(String property, X value) {
            return (X) props.put(property, value);
        }
    }

    public interface AvailableGamesPanelListener {
        void onRefreshClicked();

        void onJoinClicked();

        void onCreateClicked();
    }
}
