package com.dcscc.connector.client.common.utils;

public final class SystemUtil {
    private SystemUtil() {}

    public static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public static String getOs() {
        return System.getProperty("os.name");
    }

    public static String getArch() {
        return System.getProperty("os.arch");
    }
}
