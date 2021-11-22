package com.example.project_media_02.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import android.util.Log;

import com.example.project_media_02.ContractInterface.Contract;

import SepratePackage.aidlInterface;

public class MusicModel implements Contract.Model {
    private aidlInterface aidlObject = null;
    int PreviousResult,CurrentResult,NextResult;



    public String nam;
    public String album;
    public String artist;

    public MusicModel() {
        this.nam = nam;
        this.album = album;
        this.artist = artist;
    }

    public String getNam() {
        return nam;
    }

    public void setName(String nam) {
        this.nam = nam;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void PlayPreviousSong() {

//        try {
//         PreviousResult =   aidlObject.PerformPreviousPlay();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        Log.d("PreviousSong","Previous Song Played");

    }

    @Override
    public void PlayCurrentSong() {
        Log.d("CurrentSong","Curent Song Played");

    }

    @Override
    public void PlayNextSong() {
        Log.d("NextSong","Next Song Played");

    }
}
