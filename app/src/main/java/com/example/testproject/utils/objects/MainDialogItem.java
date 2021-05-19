package com.example.testproject.utils.objects;

public class MainDialogItem {

    private boolean isHeader;
    private String title;
    private String description;
    private int icon;
    private String time;

    public MainDialogItem(boolean isHeader, String title, String description, int icon, String time) {
        this.isHeader = isHeader;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.time = time;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }

    public String getTime() {
        return time;
    }
}
