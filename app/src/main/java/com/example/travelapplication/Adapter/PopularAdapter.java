package com.example.travelapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.travelapplication.R;
import com.example.travelapplication.activity.DetailActivity;
import com.example.travelapplication.domains.PopularDomain;

import java.text.DecimalFormat;
import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.popularViewHolder> {

    private final List<PopularDomain> list;

    public PopularAdapter(List<PopularDomain> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public popularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_popular, parent, false);
        return new popularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull popularViewHolder holder, int position) {
        holder.tv_title.setText(list.get(position).getTitle());
        holder.tv_location.setText(list.get(position).getLocation());
        holder.tv_star.setText(String.valueOf(list.get(position).getScore()));

        int drawableResId = holder.itemView.getResources().getIdentifier(list.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResId)
                .transform(new CenterCrop(), new GranularRoundedCorners(10, 10, 10, 10))
                .into(holder.imageView);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object",list.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class popularViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title, tv_location, tv_star;
        ImageView imageView;

        public popularViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_location = itemView.findViewById(R.id.tv_location);
            tv_star = itemView.findViewById(R.id.tv_star);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
