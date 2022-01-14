package com.example.project_media_02.Model;
import android.os.RemoteException;

import com.example.project_media_02.MainFragment;
import com.example.project_media_02.Presenter.ContractPresenter;

import java.util.List;
import java.util.ArrayList;

public class Model implements ContractModel {
    MainFragment mainFragment;
    public Model(ContractPresenter presenter) {
        this.presenter = presenter;
        mainFragment = new MainFragment();
    }
    ContractPresenter presenter;
    public Model() {

    }
    @Override
    public List<String> getAllAudio() {
        ArrayList<String> songTitle = new ArrayList<>();
        try {
            songTitle = (ArrayList<String>)MainFragment.getAidl().getAllAudio();
            System.out.println(MainFragment.getAidl().getAllAudio());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songTitle;
    }

    @Override
    public void playSong(int position) {
        try {
            MainFragment.getAidl().playSong(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<String> getSongDetails(int position) {
        System.out.println("getSongDetails()  called in model -----------------");
        List<String> songDetails = null;
        try {
            System.out.println("song details received at model");
            songDetails = MainFragment.getAidl().getSongDetails(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songDetails;
    }

    @Override
    public boolean playPauseSong() {
        boolean playPauseStatus = false;
        try {
            playPauseStatus = MainFragment.getAidl().playPauseSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("playPause in model called");
        return playPauseStatus;
    }
}

   /* public ServiceConnection getServiceConnectionObject() {
        ServiceConnection serviceConnectionObject = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                aidlInterface = SepratePackage.aidlInterface.Stub.asInterface(iBinder);
            }
            @Override
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        return serviceConnectionObject;
    }

    public static aidlInterface getAidl(){
        return aidlInterface;
    }*/
