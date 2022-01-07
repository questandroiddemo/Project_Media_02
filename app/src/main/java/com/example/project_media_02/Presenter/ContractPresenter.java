package com.example.project_media_02.Presenter;

import java.util.List;

public interface ContractPresenter {

    void getAllAudio();
    boolean PlayPauseButtonClick();
    void playSong(int position);
    void NextClick();
    void PreviousClick();void getSongDetails(int position);

}

