package com.example.app;

import java.util.List;

public class Course {

    private String codeLang1;
    private String codeLang2;

    private List<Category> categoriesList;

    public Course(List<Category> categoriesList) {

        this.categoriesList = categoriesList;

    }

    public List<Category> getCategoriesList() {

        return this.categoriesList;

    }

}
