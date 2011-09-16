package com.lifeboat.gwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * @author Anton Bliznets
 * @since 16.09.11
 */
public interface LifeboatClientBundle extends ClientBundle {

    public static final LifeboatClientBundle INSTANCE = GWT.create(LifeboatClientBundle.class);

    @Source("bundle.css")
    @CssResource.NotStrict
    BundleCss css();

    @Source("headerbackgr.png")
    @ImageResource.ImageOptions(repeatStyle = ImageResource.RepeatStyle.Horizontal)
    public ImageResource header();


}
