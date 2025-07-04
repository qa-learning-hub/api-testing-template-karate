package com.stripe.utils;

public class EncoderBase64 {

    public static String getEncode(String username, String password) {
        String input = username + ":" + password;
        return java.util.Base64.getEncoder().encodeToString(input.getBytes());
    }
}
