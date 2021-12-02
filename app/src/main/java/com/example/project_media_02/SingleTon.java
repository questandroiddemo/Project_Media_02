package com.example.project_media_02;

import android.util.Log;

import com.example.project_media_02.ContractInterface.Contract;

import SepratePackage.aidlInterface;

public class SingleTon implements Contract.Model {
    private static final SingleTon ourInstance = new SingleTon();
    private Object CurrentResult;
    private aidlInterface aidlObject = null;

    public static SingleTon getInstance() {
        return ourInstance;
    }


    @Override
    public void PlayPreviousSong() {

    }

    @Override
    public void PlayCurrentSong() {
        Log.d("Playsong","Current Song Played");
        

    }

    @Override
    public void PlayNextSong() {

    }
}