package com.eco.ecomarket.Model;

public class DialogModel {
    private int icon;
    private String title;
    private String subtitle;
    private String buttonText;

    public DialogModel(int icon, String title, String subtitle, String buttonText) {
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
        this.buttonText = buttonText;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
