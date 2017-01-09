package com.topu.pldriodplayerdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.topu.pldriodplayerdemo.R;
import com.topu.pldriodplayerdemo.adapter.MainItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> data = new ArrayList<>();

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainItemAdapter mainItemAdapter = new MainItemAdapter(data, getApplicationContext());
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);

        loadData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mainItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void loadData(){

        for (int i = 1; i < 20; i++){
            data.add("第"+String.valueOf(i)+"集");
        }

    }
}
