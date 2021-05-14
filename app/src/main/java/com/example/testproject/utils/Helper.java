package com.example.testproject.utils;

public class Helper {
    public static CharSequence getOnlyDigits(String string) {
        return string.replaceAll("[\\D]", "");
    }
}
