package com.example.project_media_02.ContractInterface;

public interface Contract {
    interface View{
        void setName(String name);
        void setArtist(String artist);
        void setAlbum(String album);
    }
    interface Presenter{
        void PlayPreviousSong();
        void PlayCurrentSong();
        void PlayNextSong();
        void PauseSong();
    }
}
