package com.example.testproject.utils.objects;

public class MainDialogItem {

    private boolean isAutoAnswer;
    private String message;

    public MainDialogItem(boolean isAutoAnswer, String message) {
        this.isAutoAnswer = isAutoAnswer;
        this.message = message;
    }

    public boolean isAutoAnswer() {
        return isAutoAnswer;
    }

    public String getMessage() {
        return message;
    }
}
