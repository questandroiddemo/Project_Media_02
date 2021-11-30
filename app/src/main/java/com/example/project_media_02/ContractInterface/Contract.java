package com.example.project_media_02.ContractInterface;

public interface Contract {

    interface View{
        void setpath(String path);
        void setNam(String nam);
        void setArtist(String artist);
        void setAlbum(String album);
    }

    interface Presenter{

        void PlayPreviousButtonClick();
        void PlayCurrentButtonClick();
        void PlayNextButtonClick();

    }

    interface Model {

        void PlayPreviousSong();

        void PlayCurrentSong();


        void PlayNextSong();

    }


}
