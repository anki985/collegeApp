package com.example.grosskart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_frag#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Home_frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<homeProducts> arrProducts = new ArrayList<>();
    customHomeAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_frag newInstance(String param1, String param2) {
        Home_frag fragment = new Home_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Home_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home_frag, container, false);

       //Calling IDS
        ImageSlider imageSlider = view.findViewById(R.id.imageSlider);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.offer4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.offer3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.offer2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.offer1, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        arrProducts.add(new homeProducts(R.drawable.sneaker2,"Sneaker" ));
        arrProducts.add(new homeProducts(R.drawable.bag11,"Bags" ));
        arrProducts.add(new homeProducts(R.drawable.watch7,"Watches" ));
        arrProducts.add(new homeProducts(R.drawable.perfume2,"Perfumes" ));
        arrProducts.add(new homeProducts(R.drawable.shirt7,"Shirts" ));
        arrProducts.add(new homeProducts(R.drawable.pant7,"Pants" ));

        adapter = new customHomeAdapter(getContext(),arrProducts);

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


        return  view;
    }

}