package com.example.project_media_02;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import AidlPackage.AidlInterface;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project_media_02.Model.Model;
import com.google.android.material.tabs.TabLayout;


public class MainFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Boolean connected = false;
    View v;
    static AidlInterface aidlInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragments(new SongsFragment(), "Song List");
        viewPagerAdapter.addFragments(new NowPlayingFragment(), "Now playing");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //viewPager.setCurrentItem(0); //can determine launching fragment with this line of code

        //initViewPager();

        Intent intent = new Intent("com.example.service.AIDL");

        intent.setClassName("com.example.service",
                "com.example.service.MediaService");
        if (getActivity().getBaseContext().getApplicationContext().bindService(intent, serviceConnectionObject, Context.BIND_AUTO_CREATE)) {
            connected = true;
            Toast.makeText(getContext(), "Bind service Successful - " + connected, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "BindServiceFailed" + connected, Toast.LENGTH_SHORT).show();

        }
        //return inflater.inflate(R.layout.fragment_main, container, false);
        return v;
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            aidlInterface = AidlInterface.Stub.asInterface(iBinder);
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public static AidlInterface getAidl(){
        return aidlInterface;
    }
}