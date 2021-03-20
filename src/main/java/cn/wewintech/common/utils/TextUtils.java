package cn.wewintech.common.utils;

public class TextUtils {
    public static boolean isEmpty(Object text) {
        if (text == null) {
            return true;
        }
        return text.toString().length() == 0;
    }

    public static boolean isNull(Object text) {
        return text == null;
    }
}
