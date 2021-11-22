package com.example.project_media_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Model.MusicModel;
import com.example.project_media_02.Presenter.ActivityPresenter;

import java.util.List;

import SepratePackage.aidlInterface;

public class MainActivity extends AppCompatActivity implements Contract.View {

    Contract.Presenter presenter;
    private aidlInterface aidlObject = null;
    int PreviousResult,CurrentResult,NextResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       presenter = new ActivityPresenter(this, new MusicModel());

//        bindToAIDLService();
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_main_tl_tablayout);
//        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_main_vp_viewpager);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Now Playing"));
//        tabLayout.addTab(tabLayout.newTab().setText("Settings"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
//
//        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//
//
//
//        try {
//            aidlObject.playmusic();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }



        TextView textView_SongName = findViewById(R.id.activity_main_tv_songname);
        TextView textView_Album = findViewById(R.id.activity_main_tv_album);
        TextView textView_Artist = findViewById(R.id.activity_main_tv_artist);
        ImageButton imageButton_Previous = findViewById(R.id.activity_main_ib_previous);
        ImageButton imageButton_PlayPause = findViewById(R.id.activity_main_ib_playpause);
        ImageButton imageButton_Next = findViewById(R.id.activity_main_ib_next);





        imageButton_Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    presenter.PlayPreviousButtonClick();


//                try {
//                    PreviousResult = aidlObject.PerformPreviousPlay();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
            }
        });


        imageButton_PlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               presenter.PlayCurrentButtonClick();
                try {
                    CurrentResult = aidlObject.PerformCurrentPlay();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });


        imageButton_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               presenter.PlayNextButtonClick();
//                try {
//                    NextResult = aidlObject.PerformNextPlay();
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
            }
        });


        bindToAIDLService();

}

//    private int PlayCurrentSong() {
//        return 0;
//    }
//
//    private int PlayNextSong() {
//        return 0;
//    }
//
//
//    private int PlayPreviousSong() {
//        return 0;
//    }



    @Override
    public void setNam(String nam) {



    }

    @Override
    public void setArtist(String artist) {

    }

    @Override
    public void setAlbum(String album) {

    }



    private void bindToAIDLService() {
        Intent aidlServiceIntent = new Intent("connect_to_aidl_service");
        bindService(convertImplicitIntentToExplicitIntent(aidlServiceIntent,this), serviceConnectionObject, BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            aidlObject = aidlInterface.Stub.asInterface(service);
            Toast.makeText(getApplicationContext(),"Service Connected", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(),"Service Disconnected", Toast.LENGTH_SHORT).show();

        }
    };


    public Intent convertImplicitIntentToExplicitIntent(Intent implicitIntent, Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfoList = pm.queryIntentServices(implicitIntent, 0);

        if (resolveInfoList == null || resolveInfoList.size() != 1) {
            return null;
        }
        ResolveInfo serviceInfo = resolveInfoList.get(0);
        ComponentName component = new ComponentName(serviceInfo.serviceInfo.packageName, serviceInfo.serviceInfo.name);
        Intent explicitIntent = new Intent(implicitIntent);
        explicitIntent.setComponent(component);
        return explicitIntent;

    }


}
