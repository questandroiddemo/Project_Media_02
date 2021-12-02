package com.example.project_media_02.Model;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.RemoteException;
import android.util.Log;

import com.example.project_media_02.BindingToService;
import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Presenter.ActivityPresenter;

import SepratePackage.aidlInterface;

public class MusicModel  implements Contract.Model {
   static MediaPlayer mediaPlayer;
   int position;
    private aidlInterface aidlObject = null;
    int PreviousResult, CurrentResult, NextResult;
   ActivityPresenter mactivityPresenter;
    Context mContext;

   BindingToService mBindingToService;

public MusicModel(ActivityPresenter activityPresenter,Context context)
{
    mactivityPresenter = activityPresenter;
    mContext = context;
    mBindingToService = BindingToService.getInstance ( context );

}




    @Override
    public void PlayPreviousSong() {
        try {
                    CurrentResult = aidlObject.PerformCurrentPlay();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

           Log.d("PreviousSong","Previous Song Played");

    }

    @Override
    public void PlayCurrentSong() {


          Log.d("Playsong","Current Song Played");


    }



    @Override
    public void PlayNextSong() {

        Log.d("NextSong","Next Song Played");

    }


}
