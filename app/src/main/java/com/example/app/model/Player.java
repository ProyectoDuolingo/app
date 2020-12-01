package com.example.app.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String nickname;

    List<Course> coursesList;

    Course currentCourse;

    private int coins;
    private int xpPoints;

    public Player(String nickname) {

        this.coursesList = new ArrayList<Course>();

        this.coins = 0;
        this.xpPoints = 0;

    }

    public void addCourse(Course course) {

        this.coursesList.add(course);

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getXpPoints() {
        return xpPoints;
    }

    public void setXpPoints(int xpPoints) {
        this.xpPoints = xpPoints;
    }
}
