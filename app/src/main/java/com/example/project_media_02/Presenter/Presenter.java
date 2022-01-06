package com.example.project_media_02.Presenter;

import com.example.project_media_02.View.ContractView;
import com.example.project_media_02.MainFragment;
import com.example.project_media_02.Model.Model;
import com.example.project_media_02.NowPlayingFragment;

import java.util.List;

public class Presenter implements ContractPresenter {
    Model model= new Model();
    ContractView.View view;
    ContractView.NowPlayingView nowPlayingView;
    Presenter presenter;
    int index=0;
    int songListSize;
    public Presenter(ContractView.View view) {
        this.view = view;
        model=new Model(presenter);
    }
    public Presenter() {
    }

    @Override
    public void getAllAudio(){
        List<String> songsList;
        songsList = model.getAllAudio();
        view.setSongList(songsList); // To set song list in Song List Fragment
    }
    @Override
    public void playSong(int position) {
        model.playSong(position);
    }

    @Override
    public void getSongDetails(int position) {
        index =position;
        nowPlayingView= new NowPlayingFragment();
        List<String> songDetails;
        //get details of current song
        songDetails=model.getSongDetails(position);
        nowPlayingView.setSongDetails(songDetails);
    }

    @Override
    public boolean PlayPauseButtonClick() {
        boolean playPauseStatus = model.playPauseSong();
        System.out.println("Song playing status in presenter " + playPauseStatus);
        return playPauseStatus;
    }

    @Override
    public void NextClick() {
        index++;
        System.out.println("playNextClick()  called in presenter-----------------");
        List<String> songDetails;
        songDetails = model.getSongDetails(1);
        songListSize= Integer.parseInt(songDetails.get(3));// to get count of mp3 files

        if(index>=songListSize){
            System.out.println("end of the list");
            System.out.println("index : " + index);
            index = 0;
        }
        model.playSong(index);
        songDetails = model.getSongDetails(index);
        System.out.println("inside get song details now playing object value " + nowPlayingView);
        nowPlayingView= new NowPlayingFragment();
        nowPlayingView.setSongDetails(songDetails);

    }

    @Override
    public void PreviousClick() {
        index--;

        System.out.println("playPrevious()  called in presenter-----------------");
        List<String> songDetails;
        songDetails = model.getSongDetails(1);
        songListSize= Integer.parseInt(songDetails.get(3));// to get count of mp3 files

        if(index<0) {
            System.out.println("reached at first song");
            index=songListSize-1;
        }
        model.playSong(index);
        songDetails = model.getSongDetails(index);
        System.out.println("inside get song details now playing object value " + nowPlayingView);
        nowPlayingView= new NowPlayingFragment();
        nowPlayingView.setSongDetails(songDetails);
    }

}
