package com.topu.pldriodplayerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.topu.pldriodplayerdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainReviewFragment extends Fragment {


    public MainReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_review, container, false);
    }

}
