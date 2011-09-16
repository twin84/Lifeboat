package com.lifeboat.gwt.client;

import com.google.gwt.user.client.Element;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public class Console {

    public static native void log(String message) /*-{
        if ($wnd.console) {
            $wnd.console.log(message);
        }
    }-*/;

    public static native void log(int message) /*-{
        if ($wnd.console) {
            $wnd.console.log(message);
        }
    }-*/;

    public static native void warn(String message) /*-{
        if ($wnd.console) {
            $wnd.console.warn(message);
        }
    }-*/;

    public static native void info(String message) /*-{
        if ($wnd.console && $wnd.console.info) {
            $wnd.console.info(message);
        }
    }-*/;

    public static native void error(String message) /*-{
        if ($wnd.console && $wnd.console.error) {
            $wnd.console.error(message);
        }
    }-*/;

    public static native void dir(Object obj) /*-{
        if ($wnd.console) {
            $wnd.console.dir(obj);
        }
    }-*/;

    public static native void dirxml(Element obj) /*-{
        if ($wnd.console) {
            $wnd.console.dirxml(obj);
        }
    }-*/;

    public static native void clear() /*-{
        if ($wnd.console) {
            $wnd.console.clear();
        }
    }-*/;

    public static native void time(String name) /*-{
        if ($wnd.console && $wnd.console.time) {
            $wnd.console.time(name);
        }
    }-*/;

    public static native void timeEnd(String name) /*-{
        if ($wnd.console && $wnd.console.timeEnd) {
            $wnd.console.timeEnd(name);
        }
    }-*/;

}
