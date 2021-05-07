package com.example.testproject.Utils;

public class Helper {
    public static CharSequence getOnlyDigits(String string) {
        return string.replaceAll("[\\D]", "");
    }
}
