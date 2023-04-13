package com.example.grosskart;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BagsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BagsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<SneakerProduct> arrProduct = new ArrayList<>();
    CustomSneakerAdapter adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BagsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BagsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BagsFragment newInstance(String param1, String param2) {
        BagsFragment fragment = new BagsFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bags, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = view.findViewById(R.id.recView2);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        //adding data
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));
        arrProduct.add(new SneakerProduct("$20", R.drawable.bag9, "Guess"));


        adapter = new CustomSneakerAdapter(getContext(), arrProduct);
        recyclerView.setAdapter(adapter);

        return view;
    }
}