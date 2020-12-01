package com.example.app.fragment;

import android.app.Dialog;
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
import com.example.app.util.RVAdapterCourse;

import java.util.ArrayList;
import java.util.List;

import static com.example.app.MainActivity.*;


public class CourseFragment extends Fragment {

    private View rootView;

    private RecyclerView rvCategories;
    private RVAdapterCategory rvCategoryAdapter;

    Menu toolbar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_course, container, false);

        setHasOptionsMenu(true);

        buildRVCategories();

        return rootView;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.toolbar_course, menu);

        toolbar = menu;

        toolbar.getItem(0).setIcon(player.getCurrentCourse().getCodeFlagLang1());

        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        CourseManagerFragment cmf = new CourseManagerFragment();

        cmf.show(getActivity().getSupportFragmentManager(), "cmf_tag");

        updateRVCategories();

        return true;

    }

    public void buildRVCategories() {

        rvCategories = rootView.findViewById(R.id.RecyclerViewCategories);

        rvCategories.setHasFixedSize(true);

        rvCategories.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        rvCategoryAdapter = new RVAdapterCategory(this.getActivity(), player.getCurrentCourse().getCategoriesList());

        rvCategories.setAdapter(rvCategoryAdapter);

    }

    public void updateRVCategories() {

        rvCategoryAdapter.notifyDataSetChanged();

    }

}