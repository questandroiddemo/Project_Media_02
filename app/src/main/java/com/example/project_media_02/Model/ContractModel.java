package com.example.project_media_02.Model;

import java.util.List;

public interface ContractModel {

    List<String> getAllAudio();
    void playSong(int position);
    boolean playPauseSong();
    int getCurrentPosition();
    List<String> getSongDetails(int position);
    void seekToCall(int progress);
}