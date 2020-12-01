package com.example.app.util;

import com.example.app.model.Category;

import java.util.List;

public class DiffUtilCallbackCategory extends androidx.recyclerview.widget.DiffUtil.Callback {

    private List<Category> oldList;
    private List<Category> newList;

    public DiffUtilCallbackCategory(List<Category> oldList, List<Category> newList) {

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
