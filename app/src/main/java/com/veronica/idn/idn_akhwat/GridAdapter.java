package com.veronica.idn.idn_akhwat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private ArrayList<Galery> listGalery;

    public GridAdapter(ArrayList<Galery> listGalery) {
        this.listGalery = listGalery;
    }

    @NonNull
    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_galery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridAdapter.ViewHolder holder, int position) {
        Galery galery = listGalery.get(position);
        Glide.with(holder.itemView.getContext())
                .load(listGalery.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listGalery.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_galery);
        }
    }

}
