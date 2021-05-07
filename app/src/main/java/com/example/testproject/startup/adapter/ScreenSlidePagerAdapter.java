package com.example.testproject.startup.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.testproject.startup.FirstFragment;
import com.example.testproject.startup.SecondFragment;
import com.example.testproject.startup.ThirdFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {

    private final Fragment[] fragmentArray = new Fragment[]{new FirstFragment(), new SecondFragment(), new ThirdFragment()};

    public ScreenSlidePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArray[position];
    }

    @Override
    public int getItemCount() {
        return fragmentArray.length;
    }
}