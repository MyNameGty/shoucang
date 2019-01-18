package com.example.shoucang;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class Adapter extends FragmentStatePagerAdapter {
    private ArrayList<String> tab_list;
    private ArrayList<Fragment>fra_list;

    public Adapter(FragmentManager fm, ArrayList<String> tab_list, ArrayList<Fragment> fra_list) {
        super(fm);
        this.tab_list = tab_list;
        this.fra_list = fra_list;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab_list.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fra_list.get(i);
    }

    @Override
    public int getCount() {
        return fra_list.size();
    }
}
