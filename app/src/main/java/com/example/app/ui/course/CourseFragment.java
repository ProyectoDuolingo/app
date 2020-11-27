package com.example.app.ui.course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.app.Category;
import com.example.app.Course;
import com.example.app.R;
import com.example.app.RecyclerViewAdapterCategory;

import java.util.ArrayList;
import java.util.List;


public class CourseFragment extends Fragment {

    private Course actualCourse;

    private View root;

    private CourseViewModel courseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);
        root = inflater.inflate(R.layout.fragment_course, container, false);

        setCourseCategories();

        buildRecyclerViewCategories();

        courseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

              //  textView.setText(s);

            }

        });



        return root;
    }

    public void setCourseCategories() {

        List<Category> categoriesList = new ArrayList<Category>();

        Category c1 = new Category("Food");
        Category c2 = new Category("Countries");
        Category c3 = new Category("Calendar");
        Category c4 = new Category("Furnis");
        Category c5 = new Category("Drinks");
        Category c6 = new Category("Tools");

        categoriesList.add(c1);
        categoriesList.add(c2);
        categoriesList.add(c3);
        categoriesList.add(c4);
        categoriesList.add(c5);
        categoriesList.add(c6);

        actualCourse = new Course(categoriesList);

    }

    public void buildRecyclerViewCategories() {

        RecyclerView rvCategories = root.findViewById(R.id.RecyclerViewCategories);

        rvCategories.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        RecyclerViewAdapterCategory rvAdapter = new RecyclerViewAdapterCategory(actualCourse.getCategoriesList());

        rvCategories.setAdapter(rvAdapter);
    }
}