package com.example.grosskart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SneakersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SneakersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<SneakerProduct> arrSneakerProduct = new ArrayList<>();
    CustomSneakerAdapter adapter2;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SneakersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SneakersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SneakersFragment newInstance(String param1, String param2) {
        SneakersFragment fragment = new SneakersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sneakers, container, false);

        //CALLING IDS
       RecyclerView recycler = view.findViewById(R.id.recView);

        //adding data
        arrSneakerProduct.add( new SneakerProduct("$40", R.drawable.sneaker2,"Adidas"));
        arrSneakerProduct.add( new SneakerProduct("$30", R.drawable.sneaker7,"Puma"));
        arrSneakerProduct.add(new  SneakerProduct("$40",R.drawable.sneaker3, "Nike"));
        arrSneakerProduct.add( new SneakerProduct("$40", R.drawable.sneaker2,"Adidas"));
        arrSneakerProduct.add( new SneakerProduct("$30", R.drawable.sneaker7,"Puma"));
        arrSneakerProduct.add(new  SneakerProduct("$40",R.drawable.sneaker3, "Nike"));
        arrSneakerProduct.add( new SneakerProduct("$40", R.drawable.sneaker2,"Adidas"));
        arrSneakerProduct.add( new SneakerProduct("$30", R.drawable.sneaker7,"Puma"));
        arrSneakerProduct.add(new  SneakerProduct("$40",R.drawable.sneaker3, "Nike"));
        arrSneakerProduct.add( new SneakerProduct("$40", R.drawable.sneaker2,"Adidas"));
        arrSneakerProduct.add( new SneakerProduct("$30", R.drawable.sneaker7,"Puma"));
        arrSneakerProduct.add(new  SneakerProduct("$40",R.drawable.sneaker3, "Nike"));
        arrSneakerProduct.add( new SneakerProduct("$40", R.drawable.sneaker2,"Adidas"));
        arrSneakerProduct.add( new SneakerProduct("$30", R.drawable.sneaker7,"Puma"));
        arrSneakerProduct.add(new  SneakerProduct("$40",R.drawable.sneaker3, "Nike"));
        //setting adapter

        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

        adapter2 = new CustomSneakerAdapter(getContext(), arrSneakerProduct);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter2);
        return view;
    }

    public void loadFrag(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.containerFrameLayout, fragment);

        ft.commit();
    }
}