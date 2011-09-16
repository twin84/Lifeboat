package com.lifeboat.gwt.client;


import com.google.gwt.core.client.EntryPoint;
import com.lifeboat.gwt.client.controller.LifeboatPageController;


/**
 * @author Twin
 * @version 1.0
 * @since 28.08.11
 */
public class LifeboatEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        new LifeboatPageController().initPage();
    }
}
