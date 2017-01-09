package com.topu.pldriodplayerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.topu.pldriodplayerdemo.R;
import com.topu.pldriodplayerdemo.adapter.MainItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainListFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> data = new ArrayList<>();


    public MainListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_list, container, false);

        initView(v);
        loadData();
        MainItemAdapter mainItemAdapter = new MainItemAdapter(data, getActivity().getApplicationContext());
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2);


        recyclerView.setAdapter(mainItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        return v;
    }

    private void initView(View v){
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
    }

    private void loadData(){

        for (int i = 1; i < 20; i++){
            data.add("第"+String.valueOf(i)+"集");
        }

    }

}
