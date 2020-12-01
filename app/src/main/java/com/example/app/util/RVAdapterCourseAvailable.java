package com.example.app.util;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.fragment.CourseAvailableFragment;
import com.example.app.fragment.CourseFragment;
import com.example.app.model.Course;

import java.util.List;

import static com.example.app.MainActivity.availableCourses;
import static com.example.app.MainActivity.player;

public class RVAdapterCourseAvailable extends RecyclerView.Adapter<RVAdapterCourseAvailable.ViewHolder> implements View.OnClickListener {

    Context context;
    public View.OnClickListener onClickListener;

    static List<Course> coursesList;

    public RVAdapterCourseAvailable(Context context, List<Course> coursesList) {

        this.context = context;
        this.coursesList = coursesList;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout courseAvailableItem;
        public ImageView imageViewLanguageBase;
        public ImageView imageViewLanguageCourse;

        public ViewHolder(View itemView) {

            super(itemView);

            this.courseAvailableItem = itemView.findViewById(R.id.courseAvailableItem);
            this.imageViewLanguageBase = itemView.findViewById(R.id.imageViewLanguageBase);
            this.imageViewLanguageCourse = itemView.findViewById(R.id.imageViewLanguageCourse);

        }

        public void setData(Course courseData) {

            this.imageViewLanguageBase.setImageResource(courseData.getCodeFlagLang1());
            this.imageViewLanguageCourse.setImageResource(courseData.getCodeFlagLang2());

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_courses_available_list, null, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.courseAvailableItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                player.getCoursesList().add(0, coursesList.get(viewHolder.getAdapterPosition()));

                Toast.makeText(context, "Curso entre Idioma: " + coursesList.get(viewHolder.getAdapterPosition()).getCodeFlagLang1() + " e Idioma: " + coursesList.get(viewHolder.getAdapterPosition()).getCodeFlagLang1() + " creado.", Toast.LENGTH_SHORT).show();

                availableCourses.remove(viewHolder.getAdapterPosition());

                player.setCurrentCourse(player.getCoursesList().get(0));

                CourseFragment cf = new CourseFragment();

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setData(coursesList.get(position));

    }

    @Override
    public int getItemCount() {

        return coursesList.size();

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {

        this.onClickListener = onClickListener;

    }

    @Override
    public void onClick(View v) {

        if (onClickListener != null) {

            onClickListener.onClick(v);

        }

    }

    public void updateData(List<Course> newCoursesList) {

        DiffUtilCallbackCourse diffUtilCallback = new DiffUtilCallbackCourse(this.coursesList, newCoursesList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        this.coursesList.clear();
        this.coursesList.addAll(newCoursesList);

        diffResult.dispatchUpdatesTo(this);

    }

}