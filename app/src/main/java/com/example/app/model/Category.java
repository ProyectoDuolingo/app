package com.example.app.model;

import android.graphics.Bitmap;

public class Category {

    private String name;

    private int currentLevel;

    private boolean completed;

    private Bitmap bitmap;



    public Category(String name, Bitmap bitmap) {

        this.name = name;
        this.currentLevel = 1;
        this.completed = false;
        this.bitmap = bitmap;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
