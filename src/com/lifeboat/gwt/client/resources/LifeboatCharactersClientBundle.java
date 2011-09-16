package com.lifeboat.gwt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundleWithLookup;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ResourcePrototype;

/**
 * @author Anton Bliznets
 * @since 12.09.11
 */
public interface LifeboatCharactersClientBundle extends ClientBundleWithLookup {
    public static final LifeboatCharactersClientBundle INSTANCE = GWT.create(LifeboatCharactersClientBundle.class);
    public static final String BORDER = "border";
    public static final String SUFFIX_SMALL = "Small";
    public static final String SUFFIX_MEDIUM = "Medium";
    public static final String SUFFIX_LARGE = "Large";
    public static final String[] SUFFIX = new String[]{SUFFIX_SMALL, SUFFIX_MEDIUM, SUFFIX_LARGE};

    public class Border {
        public static ImageResource getBorder(ImageResource characterResource) {
            for (String s : SUFFIX) {
                if (characterResource.getName().endsWith(s)) {
                    ResourcePrototype resource = INSTANCE.getResource(BORDER + s);
                    if (resource != null) {
                        return (ImageResource) resource;
                    }
                }
            }
            throw new IllegalArgumentException("can't find needed border resource");
        }
    }

    @Source("thekid.png")
    @ImageResource.ImageOptions(width = 135)
    public ImageResource theKidMedium();

    @Source("border.png")
    @ImageResource.ImageOptions(width = 135)
    public ImageResource borderMedium();

    @Source("thekid.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource theKidSmall();

    @Source("ladylauren.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource ladyLaurenSmall();

    @Source("sirstephen.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource sirStephenSmall();

    @Source("frenchy.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource frenchySmall();

    @Source("thecaptain.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource theCaptainSmall();

    @Source("firstmate.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource firstMateSmall();

    @Source("no_avatar.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource noAvatarSmall();

    @Source("border.png")
    @ImageResource.ImageOptions(width = 35)
    public ImageResource borderSmall();
}