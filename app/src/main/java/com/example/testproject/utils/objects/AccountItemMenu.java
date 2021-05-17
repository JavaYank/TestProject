package com.example.testproject.utils.objects;

public class AccountItemMenu {

    private int id;
    private boolean isHeader;
    private int icon;
    private String title;
    private String description;

    public AccountItemMenu(int id, boolean isHeader, int icon, String title, String description) {
        this.id = id;
        this.isHeader = isHeader;
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
