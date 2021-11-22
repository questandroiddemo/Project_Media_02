package com.example.project_media_02.Model;

import android.content.Context;
import android.content.SharedPreferences;

public class MusicModel {

    public String name;
    public String album;
    public String artist;

    public MusicModel(String name, String album, String artist) {
        this.name = name;
        this.album = album;
        this.artist = artist;
    }

    public static void init(Context context)
     {

     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
