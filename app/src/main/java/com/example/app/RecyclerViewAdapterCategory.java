package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterCategory extends RecyclerView.Adapter<RecyclerViewAdapterCategory.ViewHolder> {

    static List<Category> categoriesList;

    public RecyclerViewAdapterCategory(List<Category> categoriesList) {

        this.categoriesList = categoriesList;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewRVCategory;
        public ImageView imageViewRVCategory;

        public ViewHolder(View itemView) {

            super(itemView);

            this.textViewRVCategory = itemView.findViewById(R.id.textViewCategory);
            this.imageViewRVCategory = itemView.findViewById(R.id.imageViewCategory);

        }

        public void setData(Category categoryData) {

            this.textViewRVCategory.setText(categoryData.getName());
            this.imageViewRVCategory.setImageBitmap(categoryData.getBitmap());

        }

    }

    @NonNull
    @Override
    public RecyclerViewAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_categories_list, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCategory.ViewHolder holder, int position) {

        holder.setData(categoriesList.get(position));

    }

    @Override
    public int getItemCount() {

        return categoriesList.size();

    }

}