package com.example.project_media_02;

import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project_media_02.Model.Model;
import com.google.android.material.tabs.TabLayout;
import SepratePackage.aidlInterface;
/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Boolean connected = false;
    Model model;
    View v;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager= (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout= (TabLayout) v.findViewById(R.id.tabLayout);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragments(new SongsFragment(),"Song List");
        viewPagerAdapter.addFragments(new NowPlayingFragment(),"Now playing");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Intent intent = new Intent("com.example.service.AIDL");
        intent.setClassName("com.example.service",
                "com.example.service.MediaService");
        if (getActivity().getBaseContext().getApplicationContext().bindService(intent,model.getServiceConnectionObject(), Context.BIND_AUTO_CREATE)) {
            connected = true;
            Toast.makeText(getContext(), "Bind service Successful - " + connected, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "BindServiceFailed" + connected, Toast.LENGTH_SHORT).show();

        }

        return v;
    }


}