package com.example.grosskart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomSneakerAdapter extends RecyclerView.Adapter<CustomSneakerAdapter.ViewHolder> {
    Context context;
    ArrayList<SneakerProduct> arrSneakerProduct;
    Intent intent;

    CustomSneakerAdapter(Context context, ArrayList<SneakerProduct> arrSneakerProduct){
        this.context = context;
        this.arrSneakerProduct = arrSneakerProduct;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sneaker_fragment_custom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.price.setText(arrSneakerProduct.get(position).price);
        holder.imageView.setImageResource(arrSneakerProduct.get(position).image);
        holder.name.setText(arrSneakerProduct.get(position).name);
    }

    @Override
    public int getItemCount() {
        return arrSneakerProduct.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.img_sneakers);
            name = itemView.findViewById(R.id.name_of_sneaker);
        }
    }
}
