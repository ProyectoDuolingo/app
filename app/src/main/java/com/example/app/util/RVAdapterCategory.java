package com.example.app.util;

import android.content.Context;
import android.graphics.BitmapFactory;
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
import com.example.app.model.Category;

import java.util.List;

import static com.example.app.MainActivity.player;

public class RVAdapterCategory extends RecyclerView.Adapter<RVAdapterCategory.ViewHolder> implements View.OnClickListener {

    Context context;
    public View.OnClickListener onClickListener;

    static List<Category> categoriesList;

    public RVAdapterCategory(Context context, List<Category> categoriesList) {

        this.context = context;
        this.categoriesList = categoriesList;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout categoryItem;
        public TextView textViewRVCategory;
        public ImageView imageViewRVCategory;

        public ViewHolder(View itemView) {

            super(itemView);

            this.categoryItem = itemView.findViewById(R.id.categoryItem);
            this.textViewRVCategory = itemView.findViewById(R.id.textViewCategory);
            this.imageViewRVCategory = itemView.findViewById(R.id.imageViewCategory);

        }

        public void setData(Category categoryData) {

            this.textViewRVCategory.setText(categoryData.getName());
            this.imageViewRVCategory.setImageResource(R.drawable.category_sample);

//            this.imageViewRVCategory.setImageBitmap(categoryData.getBitmap());

        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_categories_list, null, false);

        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.categoryItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int categoryCoins = (int) (Math.random() * 25) + 25;

                int categoryXp = (int) (Math.random() * 20) + 5;

                player.setCoins(player.getCoins() + categoryCoins);
                player.setXpPoints(player.getXpPoints() + categoryXp);

                Toast.makeText(context, "Category " + categoriesList.get(viewHolder.getAdapterPosition()).getName() + " played. You won " + categoryCoins + " coins and " + categoryXp + " XP Points.", Toast.LENGTH_SHORT).show();

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setData(categoriesList.get(position));

    }

    @Override
    public int getItemCount() {

        return categoriesList.size();

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

    public void updateData(List<Category> newCategoriesList) {

        DiffUtilCallback diffUtilCallback = new DiffUtilCallback(this.categoriesList, newCategoriesList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        this.categoriesList.clear();
        this.categoriesList.addAll(newCategoriesList);

        diffResult.dispatchUpdatesTo(this);

    }



}