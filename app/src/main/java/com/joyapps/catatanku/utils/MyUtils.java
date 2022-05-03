package com.joyapps.catatanku.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ThreadLocalRandom;

public class MyUtils {
    public static String getHashedPassword(String password) {
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedPassword;
    }

    public static int getRandom(int minVal, int maxVal) {
        return ThreadLocalRandom.current().nextInt(minVal, maxVal + 1);
    }
}
