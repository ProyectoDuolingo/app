package com.example.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;

import com.example.app.model.*;
import com.example.app.fragment.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNav;

    public static Player player;

    public static int currentCourseIndex = 0;

    List<Category> categoriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        bottomNav = findViewById(R.id.bottom_navigation);

        bottomNav.setOnNavigationItemSelectedListener(navListener);

        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CourseFragment()).commit();

        }

        generatePlayer();
        generateCategories();
        generateCourses();

    }

    public void generatePlayer() {

        player = new Player("Guest3209209");

    }

    public void generateCategories() {

        categoriesList = new ArrayList<Category>();

        Bitmap categoryIcon = BitmapFactory.decodeResource(getResources(), R.drawable.category_sample);

        Category c1 = new Category("Food", categoryIcon);
        Category c2 = new Category("Countries", categoryIcon);
        Category c3 = new Category("Calendar", categoryIcon);
        Category c4 = new Category("Furnis", categoryIcon);
        Category c5 = new Category("Drinks", categoryIcon);
        Category c6 = new Category("Tools", categoryIcon);
        Category c7 = new Category("Subjects", categoryIcon);
        Category c8 = new Category("Sports", categoryIcon);

        categoriesList.add(c1);
        categoriesList.add(c2);
        categoriesList.add(c3);
        categoriesList.add(c4);
        categoriesList.add(c5);
        categoriesList.add(c6);
        categoriesList.add(c7);
        categoriesList.add(c8);

    }

    public void generateCourses() {

        List<Category> courseCategories = new ArrayList<Category>();

        for (int i = 0; i < 2; i++) {

            int categoryIndex = (int) Math.random() * (categoriesList.size()-1);

            courseCategories.add(categoriesList.get(categoryIndex));

            categoriesList.remove(categoryIndex);

        }

        Course c1 = new Course(R.drawable.flag_fr, R.drawable.flag_pt, courseCategories);

        courseCategories = new ArrayList<Category>();

        for (int i = 0; i < 2; i++) {

            int categoryIndex = (int) Math.random() * (categoriesList.size()-1);

            courseCategories.add(categoriesList.get(categoryIndex));

            categoriesList.remove(categoryIndex);

        }

        Course c2 = new Course(R.drawable.flag_pt, R.drawable.flag_ru, courseCategories);

        courseCategories = new ArrayList<Category>();

        for (int i = 0; i < 2; i++) {

            int categoryIndex = (int) Math.random() * (categoriesList.size()-1);

            courseCategories.add(categoriesList.get(categoryIndex));

            categoriesList.remove(categoryIndex);

        }

        Course c3 = new Course(R.drawable.flag_ru, R.drawable.flag_se, courseCategories);

        courseCategories = new ArrayList<Category>();

        for (int i = 0; i < 2; i++) {

            int categoryIndex = (int) Math.random() * (categoriesList.size()-1);

            courseCategories.add(categoriesList.get(categoryIndex));

            categoriesList.remove(categoryIndex);

        }

        Course c4 = new Course(R.drawable.flag_se, R.drawable.flag_fr, courseCategories);

        courseCategories = new ArrayList<Category>();

        List<Course> coursesList = new ArrayList<Course>();

        coursesList.add(c1);
        coursesList.add(c2);
        coursesList.add(c3);
        coursesList.add(c4);

        player.setCoursesList(coursesList);

    }

    // ActionBar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return false;

    }

    // BottomNav

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {

                case R.id.nav_course:

                    selectedFragment = new CourseFragment();
                    item.setIcon(R.drawable.ic_course_filled_bubble_chart_24dp);

                    break;

                case R.id.nav_profile:

                    selectedFragment = new ProfileFragment();
                    item.setIcon(R.drawable.ic_profile_filled_emoji_emotions_24dp);

                    break;

                case R.id.nav_league:

                    selectedFragment = new LeagueFragment();
                    item.setIcon(R.drawable.ic_league_filled_cup_24dp);

                    break;

                case R.id.nav_shop:

                    selectedFragment = new ShopFragment();
                    item.setIcon(R.drawable.ic_shop_filled_cart_24dp);

                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

            return true;

        }
    };


}