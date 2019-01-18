package com.example.shoucang;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<String>tab_list = new ArrayList<>();
    private ArrayList<Fragment>fra_list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        tab_list.add("矩形");
        tab_list.add("圆形");
        tab_list.add("圆角");
        Fragment_1 fragment_1 = new Fragment_1();
        Fragment_2 fragment_2 = new Fragment_2();
        Fragment_3 fragment_3 = new Fragment_3();
        fra_list.add(fragment_1);
        fra_list.add(fragment_2);
        fra_list.add(fragment_3);
        Adapter adapter = new Adapter(getSupportFragmentManager(),tab_list,fra_list);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
}
