package com.smart.mmogo.core.utils;

/*
 * String tools
 */
public  class StringU {
    public static Boolean isEmpty(Object o) {
        if (o == null || "".equals(o.toString())){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
