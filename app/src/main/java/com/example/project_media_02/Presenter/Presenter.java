package com.example.project_media_02.Presenter;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.MainFragment;
import com.example.project_media_02.Model.Model;
import com.example.project_media_02.NowPlayingFragment;

import java.util.List;

public class Presenter implements Contract.Presenter {

    Model model= new Model();
    Contract.View view;
    MainFragment mainFragment;
    Contract.NowPlayingView nowPlayingView;
    Presenter presenter;
    int index=0;
    int songListSize;
    Thread updateSeekBar = new Thread();
    int totalDuration;
    int currentPosition;

    public Presenter(Contract.View view) {
        this.view = view;
        model=new Model(presenter);
    }
    public Presenter() {

    }

    @Override
    public void getAllAudio() {
        List<String> songsList;
        songsList = model.getAllAudio();
        view.setSongList(songsList);
    }

    @Override
    public boolean PlayPauseButtonClick() {
        boolean playPauseStatus=model.playPauseSong();
        System.out.println("Song playing status in presenter "+playPauseStatus);
        return playPauseStatus;
    }

    @Override
    public void playSong(int position) {
        model.playSong(position);
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
        nowPlayingView= (Contract.NowPlayingView) new NowPlayingFragment();
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
        nowPlayingView = (Contract.NowPlayingView) new NowPlayingFragment();
        nowPlayingView.setSongDetails(songDetails);
    }

    @Override
    public void getSongDetails(int position) {
        index =position;
        nowPlayingView= (Contract.NowPlayingView) new NowPlayingFragment();
        List<String> songDetails;
        //get details of current song
        songDetails=model.getSongDetails(position);

        //to set song details and seekbar timer on nowPlaying view
        nowPlayingView.setSongDetails(songDetails);
        updateSeekBarMethod(songDetails);
        updateSeekBar.start();
    }
    private void updateSeekBarMethod(List<String> songDetails) {
        System.out.println(" updateSeekBarMethod method called.........");
        totalDuration = Integer.parseInt(songDetails.get(4));
        //updateSeekBar.start();
        updateSeekBar = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Thread run method called.........");
                System.out.println("total duration : " + totalDuration);
                System.out.println("current position : " + currentPosition);


                // int totalDuration = mediaPlayer.getDuration();
                while (totalDuration > currentPosition) {
                    try {
                        sleep(100);
                        currentPosition = model.getcPosition();
                        System.out.println("cposition in thread : " + currentPosition);
                        nowPlayingView.setProgress(currentPosition);
                        nowPlayingView.setMax(totalDuration);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
    }

    @Override
    public int getcPosition() {
        int cPosition =  model.getcPosition();
        return cPosition;
    }
}
