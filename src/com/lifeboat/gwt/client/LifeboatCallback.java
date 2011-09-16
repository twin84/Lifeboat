package com.lifeboat.gwt.client;

import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.lifeboat.gwt.client.text.LifeboatConstants;

/**
 * @author Twin
 * @version 1.0
 * @since 04.09.11
 */
public abstract class LifeboatCallback<T> implements AsyncCallback<T> {
    public void onFailure(Throwable caught) {
        if (caught instanceof StatusCodeException) {
            if (((StatusCodeException) caught).getStatusCode() == 403) {
                MessageBox.alert(LifeboatConstants.INSTANCE.dlgTitleYikes(), LifeboatConstants.INSTANCE.dlgSessionExpiredText(), new Listener<MessageBoxEvent>() {
                    public void handleEvent(MessageBoxEvent be) {
                        Window.Location.reload();
                    }
                });
            }
        }
        Console.error(this.getClass().getName() + ".onFailure(): message" + caught.getMessage());
    }
}
