package com.example.project_media_02.Model;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.example.project_media_02.MainFragment;
import com.example.project_media_02.Presenter.ContractPresenter;

import java.util.List;
import java.util.ArrayList;

import SepratePackage.aidlInterface;

public class Model implements ContractModel {
    MainFragment mainFragment;
    static aidlInterface aidlInterface;

    public Model(ContractPresenter presenter) {
        this.presenter = presenter;
        mainFragment =new MainFragment();
    }
    ContractPresenter presenter;

    public Model() {

    }

    @Override
    public List<String> getAllAudio() {
        ArrayList<String> songTitle = new ArrayList<>();
        try {
            songTitle= (ArrayList<String>) getAidl().getAllAudio();
            System.out.println(getAidl().getAllAudio());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songTitle;
    }

    @Override
    public void playSong(int position) {
        try {
            getAidl().playSong(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean playPauseSong() {
        boolean playPauseStatus = false;
        try {
            playPauseStatus=getAidl().playPauseSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("playPause in model called");
        return playPauseStatus;
    }

    @Override
    public List<String> getSongDetails(int position) {
        System.out.println("getSongDetails()  called in model -----------------");
        List<String> songDetails = null;
        try {
            System.out.println("song details received at model");
            songDetails= (List<String>) getAidl().getSongDetails(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songDetails;
    }

    @Override
    public int getcPosition() {
        int cPosition = 0;
        try {
            cPosition = getAidl().getcposition();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return cPosition;
    }

    @Override
    public void seekToCall(int progress) {
        try {
            getAidl().seekToCall(progress);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    public ServiceConnection getServiceConnectionObject() {
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
    }
}
