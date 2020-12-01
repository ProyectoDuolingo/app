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
        public TextView textViewRVCategoryLevel;
        public ImageView imageViewRVCategory;

        public ViewHolder(View itemView) {

            super(itemView);

            this.categoryItem = itemView.findViewById(R.id.categoryItem);
            this.textViewRVCategory = itemView.findViewById(R.id.textViewCategory);
            this.textViewRVCategoryLevel = itemView.findViewById(R.id.textViewCategoryLevel);
            this.imageViewRVCategory = itemView.findViewById(R.id.imageViewCategory);

        }

        public void setData(Category categoryData) {

            this.textViewRVCategory.setText(categoryData.getName());
            this.textViewRVCategoryLevel.setText(String.valueOf(categoryData.getCurrentLevel()));
            this.imageViewRVCategory.setImageResource(R.drawable.category_sample);

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

                int currentLevel = categoriesList.get(viewHolder.getAdapterPosition()).getCurrentLevel();

                if (categoriesList.get(viewHolder.getAdapterPosition()).isCompleted()) {

                    Toast.makeText(context, "Categoría " + categoriesList.get(viewHolder.getAdapterPosition()).getName() + " ya ha sido completada.", Toast.LENGTH_LONG).show();

                } else {

                    int categoryCoins = (int) (Math.random() * 25) + 25 * currentLevel;
                    int categoryXp = (int) (Math.random() * 20) + 5 * currentLevel;

                    player.setCoins(player.getCoins() + categoryCoins);
                    player.setXpPoints(player.getXpPoints() + categoryXp);

                    if (currentLevel < 5) {

                        Toast.makeText(context, "Categoría " + categoriesList.get(viewHolder.getAdapterPosition()).getName() + ". Nivel " +  currentLevel + " completado. Has ganado " + categoryCoins + " monedas y " + categoryXp + " puntos de experiencia.", Toast.LENGTH_LONG).show();

                        player.getCurrentCourse().getCategoriesList().get(viewHolder.getAdapterPosition()).setCurrentLevel(currentLevel + 1);
                        categoriesList.get(viewHolder.getAdapterPosition()).setCurrentLevel(currentLevel + 1);

                    } else {

                        player.getCurrentCourse().getCategoriesList().get(viewHolder.getAdapterPosition()).setCompleted(true);
                        categoriesList.get(viewHolder.getAdapterPosition()).setCompleted(true);

                        Toast.makeText(context, "Categoría " + categoriesList.get(viewHolder.getAdapterPosition()).getName() + ". Nivel " +  currentLevel + " completado. ¡Has completado esta categoria! Has ganado " + categoryCoins + " monedas y " + categoryXp + " puntos de experiencia.", Toast.LENGTH_LONG).show();

                    }

                    notifyDataSetChanged();

                }

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

        DiffUtilCallbackCategory diffUtilCallback = new DiffUtilCallbackCategory(this.categoriesList, newCategoriesList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        this.categoriesList.clear();
        this.categoriesList.addAll(newCategoriesList);

        diffResult.dispatchUpdatesTo(this);

    }



}