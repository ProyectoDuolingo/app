package com.example.app.util;

import android.content.Context;
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
import com.example.app.model.Course;

import java.util.List;

import static com.example.app.MainActivity.player;

public class RVAdapterCourse extends RecyclerView.Adapter<RVAdapterCourse.ViewHolder> implements View.OnClickListener {

    Context context;
    public View.OnClickListener onClickListener;

    static List<Course> coursesList;

    public RVAdapterCourse(Context context, List<Course> coursesList) {

        this.context = context;
        this.coursesList = coursesList;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout courseItem;
        public ImageView imageViewRVFlag;
        public TextView textViewRVLanguage;

        public ViewHolder(View itemView) {

            super(itemView);

            this.courseItem = itemView.findViewById(R.id.courseItem);
            this.imageViewRVFlag = itemView.findViewById(R.id.imageViewCourseFlag);
            this.textViewRVLanguage = itemView.findViewById(R.id.textViewCourseLanguage);

        }

        public void setData(Course courseData) {

            this.imageViewRVFlag.setImageResource(courseData.getCodeFlagLang1());
            this.textViewRVLanguage.setText(String.valueOf(courseData.getCodeFlagLang1()));

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_courses_list, null, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.courseItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (coursesList.size() > 1) {

                    player.setCurrentCourse(coursesList.get(viewHolder.getAdapterPosition()));

                    player.getCoursesList().add(0, player.getCurrentCourse());
                    player.getCoursesList().remove(viewHolder.getAdapterPosition()+1);

                }

                Toast.makeText(context, "Curso " + coursesList.get(viewHolder.getAdapterPosition()).getCodeFlagLang1() + " seleccionado.", Toast.LENGTH_SHORT).show();

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