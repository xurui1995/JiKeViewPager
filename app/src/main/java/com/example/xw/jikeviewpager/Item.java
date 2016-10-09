package com.example.xw.jikeviewpager;

/**
 * Created by xw on 2016/10/9.
 */
public class Item {
    private int imageId;
    private String text;

    public Item(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
