package net.xiaocun.utils;

/**
 * Created by Administrator on 2016/11/26.
 */
public class StringUtils {
    public static boolean isBlank(String str) {
        if (str != null && str.length() >0) {
            return false;
        }
        return true;

    }
}
