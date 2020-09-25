package com.example.apple.magna;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Lenovo on 3/25/2016.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter {
    public static int numberofquestions=5;
    public SwipeAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int i)
    {
        Fragment fragment=new PageFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("questionnumber",i+1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount()
    {
        return numberofquestions;
    }

}
