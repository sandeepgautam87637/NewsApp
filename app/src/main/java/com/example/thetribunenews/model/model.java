package com.example.thetribunenews.model;

public class model {
    int img;
    String newstext;
    String date;

    public model(int img, String newstext, String date) {
        this.img = img;
        this.newstext = newstext;
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNewstext() {
        return newstext;
    }

    public void setNewstext(String newstext) {
        this.newstext = newstext;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
