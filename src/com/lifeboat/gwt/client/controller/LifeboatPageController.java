package com.lifeboat.gwt.client.controller;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.RootPanel;
import com.lifeboat.gwt.client.*;
import com.lifeboat.gwt.client.model.AvailableGame;
import com.lifeboat.gwt.client.model.PlayerBasicInfo;
import com.lifeboat.gwt.client.resources.LifeboatCharactersClientBundle;
import com.lifeboat.gwt.client.model.Character;
import com.lifeboat.gwt.client.model.PageInitialState;
import com.lifeboat.gwt.client.event.LifeboatEvent;
import com.lifeboat.gwt.client.event.LifeboatEventBus;
import com.lifeboat.gwt.client.event.TextMessageEvent;
import com.lifeboat.gwt.client.resources.LifeboatClientBundle;
import com.lifeboat.gwt.client.widgets.EnterNamePanel;
import com.lifeboat.gwt.client.widgets.TopPanelPlayerStatus;
import net.zschech.gwt.comet.client.CometListener;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Bliznets
 * @since 09.09.11
 */
public class LifeboatPageController {

    private final LifeboatEventBus bus = new LifeboatEventBus();
    private final Map<Character, String> characterColors = new HashMap<Character, String>();
    private final GameModel gameModel = new GameModel();
    private PageFrame frame = new PageFrame();

    public void initPage() {
        LifeboatClientBundle.INSTANCE.css().ensureInjected();
        characterColors.put(Character.THE_KID, "red");
        characterColors.put(Character.LADY_LAUREN, "blue");
        characterColors.put(Character.SIR_STEPHEN, "yellow");
        characterColors.put(Character.FRENCHY, "gray");
        characterColors.put(Character.THE_CAPTAIN, "black");
        characterColors.put(Character.FIRST_MATE, "brown");

        RootPanel.get().add(frame);
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.theKidSmall()).createImage());
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.ladyLaurenSmall()).createImage());
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.sirStephenSmall()).createImage());
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.frenchySmall()).createImage());
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.theCaptainSmall()).createImage());
        RootPanel.get().add(AbstractImagePrototype.create(LifeboatCharactersClientBundle.INSTANCE.firstMateSmall()).createImage());
/*
        PlayGameService.App.getInstance().foo(new LifeboatCallback<Void>() {
            public void onSuccess(Void result) {
                Console.info("foo");
            }
        });
*/

        final ActivityTipsController activityTipsController = new ActivityTipsController();
        activityTipsController.setColors(characterColors);
        bus.addHandler(TextMessageEvent.class, activityTipsController);

        StartGameService.App.getInstance().connectPlayer(new LifeboatCallback<PageInitialState>() {
            public void onSuccess(PageInitialState result) {
                if (result == null || result.getCurrentPlayer() == null) {
                    enterPlayerName(result != null ? result.getAvailableGames() : null);
                } else {
                    restoreCurrentGame(result);
                }
            }
        });

        CometListener listener = new CometListener() {
            public void onConnected(int heartbeat) {
            }

            public void onDisconnected() {
            }

            public void onHeartbeat() {
            }

            public void onRefresh() {
            }

            public void onError(Throwable exception, boolean connected) {
                Console.error("CometListener.onError(): " + exception.toString());
            }

            public void onMessage(List<? extends Serializable> messages) {
                for (Serializable message : messages) {
                    if (message instanceof LifeboatEvent) {
                        bus.fireEvent((LifeboatEvent) message);
                    } else {
                        Console.error("CometListener. Server message" + message + " is not an LifeboatEvent instance");
                    }
                }
            }
        };

//        CometClient client = new CometClient("/CometServlet", listener);
//        client.start();
//        bus.fireEvent(new TextMessageEvent("asdf fdsa", Character.FRENCHY));
//        bus.fireEvent(new TextMessageEvent(5, Character.LADY_LAUREN, "bla-bla-bla <b>123</b>"));
    }

    private void enterPlayerName(final List<AvailableGame> availableGames) {
        new EnterNamePanel(new EnterNamePanel.EnterNameDialogListener() {
            public void onNameEntered(String name, String hexColor) {
                gameModel.setPlayer(new PlayerBasicInfo(name, hexColor));
                frame.setTopPanel(new TopPanelPlayerStatus(LifeboatCharactersClientBundle.INSTANCE.noAvatarSmall(), gameModel.getPlayer()));
                showAvailableGames(availableGames);
            }
        }).show();
    }

    private void restoreCurrentGame(PageInitialState result) {
        // init game model
        Console.error("Not implemented yet");
        throw new UnsupportedOperationException();
    }

    private void showAvailableGames(List<AvailableGame> availableGames) {

    }
}
