package com.example.project_media_02.Presenter;

import android.content.pm.PackageManager;

import androidx.fragment.app.FragmentActivity;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Model.MusicModel;
import com.example.project_media_02.NowPlaying_Fragment;

import SepratePackage.aidlInterface;

public class ActivityPresenter implements Contract.Presenter, Contract.MusicPlayer {
    private Contract.View view;
    private Contract.Model model;
   // private Contract.MusicPlayer musicPlayer;


    public ActivityPresenter(Contract.View view, NowPlaying_Fragment nowPlaying_fragment, MusicModel model) {
        this.view = view;
        this.model = model;

    }


    @Override
    public void PlayPreviousButtonClick() {

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


}