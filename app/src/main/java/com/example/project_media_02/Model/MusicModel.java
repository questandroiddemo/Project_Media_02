package com.example.project_media_02.Model;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import com.example.project_media_02.BindingToService;
import com.example.project_media_02.ContractInterface.Contract;

public class MusicModel  implements Contract.Model {
   static MediaPlayer mediaPlayer;
   int position;

    public MusicModel() {

    }
//    public String path;
//    public String nam;
//    public String album;
//    public String artist;
//
//    public MusicModel() {
//
//        this.path = path;
//        this.nam = nam;
//        this.album = album;
//        this.artist = artist;
//    }
//
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public String getNam() {
//        return nam;
//    }
//
//    @Override
//    public void setpath(String path) {
//
//    }
//
//    @Override
//    public void setNam(String nam) {
//        this.nam = nam;
//    }
//
//    public String getAlbum() {
//        return album;
//    }
//
//    @Override
//    public void setAlbum(String album) {
//        this.album = album;
//    }
//
//    public String getArtist() {
//        return artist;
//    }
//
//    @Override
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }

    public MusicModel(Contract.Presenter presenter1, Context context){
        BindingToService bind = BindingToService.getInstance ( context );
    }
    @Override
    public void PlayPreviousSong() {

           Log.d("PreviousSong","Previous Song Played");

    }

    @Override
    public void PlayCurrentSong() {


          Log.d("Playsong","Current Song Played");


    }



    @Override
    public void PlayNextSong() {

        Log.d("NextSong","Next Song Played");

    }


}
