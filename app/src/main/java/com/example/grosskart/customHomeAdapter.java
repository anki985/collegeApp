package com.example.grosskart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customHomeAdapter extends RecyclerView.Adapter<customHomeAdapter.ViewHolder> {
    Context context;
    ArrayList<homeProducts> arrProducts;
    Intent intent;
    Fragment fragment;

    public customHomeAdapter(Context context, ArrayList<homeProducts> arrProducts){
        this.context = context;
        this.arrProducts = arrProducts;
    }

    

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_items_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        homeProducts homeProd = arrProducts.get(position);
        holder.img.setImageResource(arrProducts.get(position).img);
        holder.textView.setText(arrProducts.get(position).name);


        //code for open new activity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                switch (holder.getAdapterPosition()){
                    case 0 :
                        fragment = new SneakersFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    case 1 :
                        fragment = new BagsFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    case 2 :
                        fragment = new WatchesFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    case 3 :
                        fragment = new PerfumesFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    case 4 :
                        fragment = new shirtsFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    case 5:
                        fragment = new pantsFragment();
                        appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fragment).commit();
                        break;
                    default:
                        Toast.makeText(context, "Nothing", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return arrProducts.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_sneakers_home);
            textView = itemView.findViewById(R.id.textViewOfProduct);
        }
    }

}
