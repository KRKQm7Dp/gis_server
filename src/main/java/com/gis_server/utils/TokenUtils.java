package com.gis_server.utils;

import org.springframework.util.DigestUtils;

public class TokenUtils {

    private static String salt = "gis_server";

    public static String MD5Encode(String str) {
        String base = str + "/" + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }

    public static String newToken(String username, String date) {
        return MD5Encode(username + date);
    }

}
