package com.lifeboat.gwt.client.text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

/**
 * @author Anton Bliznets
 * @since 09.09.11
 */
public interface LifeboatConstants extends Constants {
    public static final LifeboatConstants INSTANCE = GWT.create(LifeboatConstants.class);

    @Key("dlg.btn.ok")
    String dlgBtnOk();

    @Key("dlg.btn.cancel")
    String dlgBtnCancel();

    @Key("dlg.title.yikes")
    String dlgTitleYikes();

    @Key("dlg.session.expired.text")
    String dlgSessionExpiredText();

    String enterNameTitle();

    String enterNameText();

    String enterErrColor();

    String validatorFieldEmpty();

    String validatorFieldTooLong();

    String enterNameColorPrompt();

    String enterNameFieldName();

    String enterNameFieldColor();

    String enterNameSubmit();

    String dlgBtnSelectColor();

    String enterNameFieldColorHint();

    String lifeboatTitle();

    String avGameNum();

    String avGamePlayerName();

    String avGamePlayersCount();
}
