package com.example.project_media_02.ContractInterface;

import android.os.RemoteException;

import SepratePackage.aidlInterface;

public interface Contract {

    interface View{

        void setNam(String nam);
        void setArtist(String artist);
        void setAlbum(String album);
    }

    interface Presenter{

        void PlayPreviousButtonClick();
        void PlayCurrentButtonClick();
        void PlayNextButtonClick();
        void PauseSong();
    }

    interface Model{

        void PlayPreviousSong() ;
        void PlayCurrentSong();
        void PlayNextSong();

    }
}
