package com.example.travelapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.travelapplication.R;
import com.example.travelapplication.domains.CategoryDomain;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.categoryViewHolder> {
    private final List<CategoryDomain> list;

    public CategoryAdapter(List<CategoryDomain> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CategoryAdapter.categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category,parent,false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.categoryViewHolder holder, int position) {
        holder.tv_title_text.setText(list.get(position).getTitle());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.iv_category);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title_text;
        ImageView iv_category;

        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title_text = itemView.findViewById(R.id.tv_title_text);
            iv_category = itemView.findViewById(R.id.tv_title_text);
        }
    }
}
