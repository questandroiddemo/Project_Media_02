package com.example.project_media_02.Presenter;

public interface ContractPresenter {
    void getAllAudio();
    boolean PlayPauseButtonClick();
    void playSong(int position);
    void NextClick();
    void PreviousClick();
    void getSongDetails(int position);
    int getcPosition();
}

