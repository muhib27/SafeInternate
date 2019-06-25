package com.champs21.safeinternate.activity.model;


public class Item {

    public String text;
    public int drawable;
    public String date;

    public Item(String text, int drawable, String date ) {
        this.text = text;
        this.drawable = drawable;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
