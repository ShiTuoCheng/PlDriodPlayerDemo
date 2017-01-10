package com.topu.pldriodplayerdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.topu.pldriodplayerdemo.R;
import com.topu.pldriodplayerdemo.adapter.MainViewPagerAdapter;

public class MainActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mTabLayout = (TabLayout)findViewById(R.id.tabBarLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        addTab("播放列表");
        addTab("评论");

        MainViewPagerAdapter detailViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());

        viewPager.setAdapter(detailViewPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void addTab(String str){
        mTabLayout.addTab(mTabLayout.newTab().setText(str));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.webViewPlayer){

            Intent intent = new Intent(MainActivity.this, WebViewPlayerActivity.class);

            startActivity(intent);
        }

        return true;
    }
}
