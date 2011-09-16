package com.lifeboat.gwt.client;

import java.util.Collection;

/**
 * @author Anton Bliznets
 * @since 02.09.11
 */
public final class Util {
    public static void checkNullAndThrowNPE(Object... o) {
        if (o.length < 1) {
            throw new NullPointerException();
        }
        for (Object o1 : o) {
            if (o1 == null) {
                throw new NullPointerException();
            }
        }
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }
}