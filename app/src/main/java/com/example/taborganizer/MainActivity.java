package com.example.taborganizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    public static HashMap<String,ArrayList<String>> lists=new HashMap<String,ArrayList<String>>();
    public static ArrayList<String> listsNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lists= new HashMap<String,ArrayList<String>>();
        listsNames = new ArrayList<String>();

        viewPager = findViewById(R.id.viewPager);

        addTabs(viewPager);
        ((TabLayout) findViewById(R.id.tabLayout)).setupWithViewPager( viewPager );


    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentOne(), "kithara.to");
        adapter.addFrag(new FragmentTwo(), "lists");
        viewPager.setAdapter(adapter);
    }
}