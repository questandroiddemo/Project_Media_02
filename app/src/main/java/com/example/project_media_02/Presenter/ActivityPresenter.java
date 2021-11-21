package com.example.project_media_02.Presenter;

import com.example.project_media_02.ContractInterface.Contract;

public class ActivityPresenter implements Contract.Presenter {
    Contract.View view;

    public ActivityPresenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void PlayPreviousSong() {

    }

    @Override
    public void PlayCurrentSong() {

    }

    @Override
    public void PlayNextSong() {

    }

    @Override
    public void PauseSong() {

    }
}
