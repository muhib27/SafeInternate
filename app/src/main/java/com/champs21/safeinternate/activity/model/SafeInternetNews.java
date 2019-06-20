package com.champs21.safeinternate.activity.model;


public class SafeInternetNews {

    public String date;
    public String title;


    public SafeInternetNews(String date, String title) {
        this.date = date;
        this.title = title;
    }

    public SafeInternetNews() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
