package com.example.project_media_02;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context context;
    int tabcount;

    public MyAdapter(Context context1, FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        context = context1;
        this.tabcount = tabCount;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                NowPlaying_Fragment nowPlaying_fragment = new NowPlaying_Fragment();
                return nowPlaying_fragment;

            case 1:
                Settings_Fragment settings_fragment = new Settings_Fragment();
                return settings_fragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
