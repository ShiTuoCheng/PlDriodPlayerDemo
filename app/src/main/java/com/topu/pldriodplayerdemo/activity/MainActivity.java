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
import com.topu.pldriodplayerdemo.utils.Utils;
import com.topu.pldriodplayerdemo.view.CountDownView;

public class MainActivity extends AppCompatActivity {

    private CountDownView countDownView;
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
        countDownView = (CountDownView)findViewById(R.id.fragment_count_down);

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

        countDownView.setCountDownTimerListener(new CountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {
                Utils.showToast(getApplicationContext(), "开始了");
            }

            @Override
            public void onFinishCount() {
                Utils.showToast((getApplicationContext()), "结束了");

            }
        });

        countDownView.start();
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
