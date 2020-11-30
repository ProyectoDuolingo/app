package com.example.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.Category;
import com.example.app.model.Course;
import com.example.app.util.RVAdapterCategory;

import java.util.ArrayList;
import java.util.List;

import static com.example.app.MainActivity.*;


public class CourseFragment extends Fragment {

    private View rootView;

    private RecyclerView rvCategories;
    private RVAdapterCategory rvCategoryAdapter;

    Course currentCourse;

    List<Category> categoriesList = new ArrayList<Category>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_course, container, false);

        setHasOptionsMenu(true);

        buildRVCategories();

        return rootView;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.toolbar_course, menu);

        menu.getItem(0).setIcon(player.getCoursesList().get(currentCourseIndex).getCodeFlagLang1());

        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.currentCourseFlag) {

            if (currentCourseIndex == 3) {

                currentCourseIndex = 0;

            } else {

                currentCourseIndex++;

            }

            item.setIcon(player.getCoursesList().get(currentCourseIndex).getCodeFlagLang1());

            currentCourse = player.getCoursesList().get(currentCourseIndex);

            System.out.println("Current course = " + currentCourseIndex + " categories = " + currentCourse.getCategoriesList().size());

            updateRV();

        }

        return false;

    }

    public void buildRVCategories() {

        rvCategories = rootView.findViewById(R.id.RecyclerViewCategories);

        rvCategories.setHasFixedSize(true);

        rvCategories.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        currentCourse = player.getCoursesList().get(currentCourseIndex);

        categoriesList.addAll(currentCourse.getCategoriesList());

        rvCategoryAdapter = new RVAdapterCategory(this.getActivity(), categoriesList);

        rvCategoryAdapter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Category " + categoriesList.get(rvCategories.getChildAdapterPosition(v)).getName() + " played." , Toast.LENGTH_SHORT).show();

            }
        });

        rvCategories.setAdapter(rvCategoryAdapter);

    }

    public void updateRV() {

        categoriesList.clear();

        System.out.println("Updating Categories SIZE = " + categoriesList.size());

        for (int i = 0; i < currentCourse.getCategoriesList().size(); i++) {

            System.out.println("Adding Category " + i + " with name = " + currentCourse.getCategoriesList().get(i).getName());

            categoriesList.add(currentCourse.getCategoriesList().get(i));

        }

        System.out.println("Updated Categories SIZE = " + categoriesList.size());

        rvCategoryAdapter.updateData(categoriesList);

    }

}