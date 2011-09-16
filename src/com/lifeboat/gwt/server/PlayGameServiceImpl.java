package com.lifeboat.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.lifeboat.gwt.client.PlayGameService;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class PlayGameServiceImpl extends RemoteServiceServlet implements PlayGameService {
    public void foo() {
        getThreadLocalRequest().getSession(false);
    }
}