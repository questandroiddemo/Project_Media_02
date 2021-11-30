package com.example.project_media_02.Presenter;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Model.MusicModel;
import com.example.project_media_02.NowPlaying_Fragment;

public class ActivityPresenter implements Contract.Presenter,Contract.View{

    private Contract.View view;
    private Contract.Model model;




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


    @Override
    public void setpath(String path) {

    }

    @Override
    public void setNam(String nam) {

    }

    @Override
    public void setArtist(String artist) {

    }

    @Override
    public void setAlbum(String album) {

    }
}