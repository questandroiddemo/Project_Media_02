package com.example.project_media_02.Presenter;

import android.content.pm.PackageManager;

import com.example.project_media_02.ContractInterface.Contract;

import SepratePackage.aidlInterface;

public class ActivityPresenter implements Contract.Presenter{
    private Contract.View view;
    private Contract.Model model;


    public ActivityPresenter(Contract.View view, Contract.Model model) {
        this.view = view;
        this.model = model;
    }




    @Override
    public void PlayPreviousButtonClick()  {

        model.PlayPreviousSong();

    }

    @Override
    public void PlayCurrentButtonClick() {
        model.PlayCurrentSong();

    }

    @Override
    public void PlayNextButtonClick() {
        model.PlayNextSong();

    }

    @Override
    public void PauseSong() {

    }
}
