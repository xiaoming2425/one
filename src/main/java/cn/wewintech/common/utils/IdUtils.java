package cn.wewintech.common.utils;

import java.util.UUID;

public class IdUtils {
    public static String getUuid() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "").toLowerCase();
    }
}
