package com.example.app.util;

import com.example.app.model.Category;
import com.example.app.model.Course;

import java.util.List;

public class DiffUtilCallbackCourse extends androidx.recyclerview.widget.DiffUtil.Callback {

    private List<Course> oldList;
    private List<Course> newList;

    public DiffUtilCallbackCourse(List<Course> oldList, List<Course> newList) {

        this.oldList = oldList;
        this.newList = newList;

    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition == newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition) == newList.get(newItemPosition);
    }
}
