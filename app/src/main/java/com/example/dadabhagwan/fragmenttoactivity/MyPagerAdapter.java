package com.example.dadabhagwan.fragmenttoactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by dadabhagwan on 12/21/2016.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int[] img={R.drawable.bg,R.drawable.download,R.drawable.wall2,R.drawable.wallpaper1};
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MyViewPagerFragment.newInstance(position,img[position]);
    }

    @Override
    public int getCount() {
        return img.length;
    }
}
