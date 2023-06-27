package org.example.Util;

import org.example.Asserts.AssertContainer;

public class PageUtils {

    public static <T, P> T ifNotNullElse(P obj, T p1, T p2){
        return obj != null ? p1 : p2;
    }
    public static <T> T orElse(T e){
        return e;
    }

    public static <T> T ifNullAssert(T e){
        if (e == null) {
            AssertContainer.addAssert("Объект " + e.getClass().getSimpleName() + " - null");
        }
        return e;
    }



}
