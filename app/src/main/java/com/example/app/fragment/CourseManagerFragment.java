package com.example.app.fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.Course;
import com.example.app.util.RVAdapterCourse;

import java.util.List;

import static com.example.app.MainActivity.*;

public class CourseManagerFragment extends DialogFragment {

    private View rootView;

    private RecyclerView rvCourses;
    private RVAdapterCourse rvAdapterCourse;

    private Button addCourse;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.dialog_courses_list, container);

        addCourse = rootView.findViewById(R.id.buttonAddCourse);

        if (availableCourses.size() == 0) {

            addCourse.setVisibility(View.INVISIBLE);

        }

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CourseAvailableFragment caf = new CourseAvailableFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, caf).commit();

                dismiss();

            }
        });

        buildRVCourses();

        return rootView;

    }

    public void buildRVCourses() {

        rvCourses = rootView.findViewById(R.id.RecyclerViewCourses);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());

        llm.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvCourses.setLayoutManager(llm);

        rvAdapterCourse = new RVAdapterCourse(this.getActivity(), player.getCoursesList());

        rvCourses.setAdapter(rvAdapterCourse);

    }
}
