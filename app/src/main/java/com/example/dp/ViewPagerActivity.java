package com.example.dp;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dp.Model.House;

import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private List<House> houses;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mViewpager=(ViewPager) findViewById(R.id.act_view);

    }

}
