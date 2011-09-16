package com.lifeboat.gwt.server;

import javax.servlet.http.HttpSession;

/**
 * @author Twin
 * @version 1.0
 * @since 04.09.11
 */
public final class Util {
    private Util() {
    }

    public static String getPlayerId(HttpSession session) {
        if (session != null) {
            try {
                return session.getId();
            } catch (IllegalStateException e) {//invalid session
                return null;
            }
        }
        return null;
    }
}
