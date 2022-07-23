package com.example.myapplication;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class stringToMD5 {




    public static String stringToMD5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b: hash) {
           if((b & 0xFF) < 0x10 ) {
               hex.append("0");
           }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
}