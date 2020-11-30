package com.example.app.model;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private int codeFlagLang1;
    private int codeFlagLang2;

    private List<Category> categoriesList;

    public Course(int codeFlagLang1, int codeFlagLang2, List<Category> categoriesList) {

        this.codeFlagLang1 = codeFlagLang1;
        this.codeFlagLang2 = codeFlagLang2;

        this.categoriesList = categoriesList;

    }

    public List<Category> getCategoriesList() {

        return this.categoriesList;

    }

    public void addCategory(Category category) {

        this.categoriesList.add(category);

    }

    public int getCodeFlagLang1() {
        return codeFlagLang1;
    }

    public int getCodeFlagLang2() {
        return codeFlagLang2;
    }

    public void setCodeFlagLang1(int codeFlagLang1) {
        this.codeFlagLang1 = codeFlagLang1;
    }

    public void setCodeFlagLang2(int codeFlagLang2) {
        this.codeFlagLang2 = codeFlagLang2;
    }
}
