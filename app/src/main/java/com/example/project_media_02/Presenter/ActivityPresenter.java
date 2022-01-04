//package com.example.project_media_02.Presenter;
//
//import com.example.project_media_02.ContractInterface.Interface_NowPlaying_Model;
//import com.example.project_media_02.ContractInterface.Interface_NowPlaying_Presenter;
//import com.example.project_media_02.ContractInterface.Interface_NowPlaying_View;
//import com.example.project_media_02.Model.MusicModel;
//
//public class ActivityPresenter implements Interface_NowPlaying_Presenter.Presenter{
//
//
//    Interface_NowPlaying_View.View view;
//    Interface_NowPlaying_Model.Model mMainActivityModel;
//    Interface_NowPlaying_Presenter presenter;
//
//    public ActivityPresenter(Interface_NowPlaying_View.View view) {
//        this.view = (Interface_NowPlaying_View.View) view;
//
//        mMainActivityModel = new MusicModel ( presenter );
//
//    }
//
//
//
//    @Override
//    public void PlayPreviousButtonClick()  {
//
//        mMainActivityModel.PlayPreviousSong ();
//    }
//
//    @Override
//    public void PlayCurrentButtonClick()  {
//        mMainActivityModel.PlayCurrentSong ();
//
//    }
//
//    @Override
//    public void PlayNextButtonClick() {
//        mMainActivityModel.PlayNextSong ();
//
//    }
//
//
//
//
//
//
//}