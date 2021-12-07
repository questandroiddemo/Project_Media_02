package com.example.project_media_02.Presenter;

import android.content.Context;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Model.MusicModel;

public class ActivityPresenter implements Contract.Presenter{


    Contract.View view;
    Contract.Model mMainActivityModel;

    public ActivityPresenter(Contract.View view, Context context) {
        this.view = view;

        mMainActivityModel = new MusicModel (  this, context);

    }

    @Override
    public void PlayPreviousButtonClick() {

        mMainActivityModel.PlayPreviousSong ();
    }

    @Override
    public void PlayCurrentButtonClick() {
        mMainActivityModel.PlayCurrentSong ();

    }

    @Override
    public void PlayNextButtonClick() {
        mMainActivityModel.PlayNextSong ();

    }






}