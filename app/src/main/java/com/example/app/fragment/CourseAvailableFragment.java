package com.example.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.app.R;
import com.example.app.util.RVAdapterCategory;
import com.example.app.util.RVAdapterCourseAvailable;

import static com.example.app.MainActivity.availableCourses;
import static com.example.app.MainActivity.player;

public class CourseAvailableFragment extends Fragment {

    View rootView;

    RecyclerView rvCourseAvailable;
    RVAdapterCourseAvailable rvCourseAvailableAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_course_available, container, false);

        buildRVAvailableCourses();

        return rootView;

    }

    public void buildRVAvailableCourses() {

        rvCourseAvailable = rootView.findViewById(R.id.RecyclerViewCourseAvailables);

        rvCourseAvailable.setHasFixedSize(true);

        rvCourseAvailable.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        rvCourseAvailableAdapter = new RVAdapterCourseAvailable(this.getActivity(), availableCourses);

        rvCourseAvailable.setAdapter(rvCourseAvailableAdapter);

    }

}
