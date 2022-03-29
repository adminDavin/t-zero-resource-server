package com.t.zero.common.base.check;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.ObjectUtils;

import static java.lang.String.format;

public class CheckUtils {

    public static <T> void check(List<T> list, String message, Function<List<T>, Boolean> function) {
        Boolean out = function.apply(list);
        if (!out) {
            throw new RuntimeException(message);
        }
    }

    public static <T> void checkListEmpty(List<T> list, Function<List<T>, Boolean> function) {
        check(list, "collection can't be empty", function);
    }

    public static <T> void checkListEmpty(List<T> list, String key, Function<List<T>, Boolean> function) {
        check(list, String.format("%s is invalid for related collection is empty", key), function);
    }

    public static void checkObjectIsNull(Object o, Function<Object, Boolean> function) {
        Boolean out = function.apply(o);
        if (!out) {
            throw new RuntimeException("Object can't be null");
        }
    }

    public static void checkObjectIsNull(Object o, String key, Function<Object, Boolean> function) {
        Boolean out = function.apply(o);
        if (!out) {
            throw new RuntimeException(String.format("%s is invalid for related Object is null", key));
        }
    }

    public static void checkIntegerIsNull(Integer value, String key) {
        if (ObjectUtils.isEmpty(value)) {
            throw new RuntimeException(String.format("%s can't be null", key));
        }
    }

    public static void checkStringIsNull(String value, String key) {
        if (ObjectUtils.isEmpty(value)) {
            throw new RuntimeException(String.format("%s can't be null", key));
        }
    }

    public static void throwException(String message, String value) {
        throw new RuntimeException(format(message, value));
    }

    public static void throwException(boolean flag, String message, String value) {
        if (flag) {
            throw new RuntimeException(format(message, value));
        }
    } 

    public static void throwException(boolean flag, String message, int userId, String value) {
        if (flag) {
            throw new RuntimeException(format(message, userId, value));
        }
    }
}
