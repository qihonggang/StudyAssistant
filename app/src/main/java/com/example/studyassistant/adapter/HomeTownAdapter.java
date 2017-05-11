package com.example.studyassistant.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.studyassistant.fragments.HomeTown2Fragment;
import com.example.studyassistant.fragments.HomeTown3Fragment;
import com.example.studyassistant.fragments.WorldFragment;


/**
 * Created by Administrator on 2016/10/30.12:31
 */
public class HomeTownAdapter extends FragmentPagerAdapter {
    private String[] datas;

    public HomeTownAdapter(FragmentManager fm, String[] datas) {
        super(fm);
        this.datas=datas;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeTown3Fragment();
            case 1:
                return  new WorldFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return datas[position];
    }
}
