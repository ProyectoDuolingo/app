package com.example.app.model;

import android.graphics.Bitmap;

public class Category {

    private String name;

    private Bitmap bitmap;

    public Category(String name, Bitmap bitmap) {

        this.name = name;
        this.bitmap = bitmap;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

}
