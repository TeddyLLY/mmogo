package com.smart.mmogo.core.utils;

/*
 * String tools
 */
public class StringU {
    public static Boolean isEmpty(Object o) {
        return o == null || "".equals(o.toString());
    }

    public static Boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
