package com.example.project_media_02.View;

import java.util.List;

public interface ContractView {
    //for songListFragment
    interface View {
        //updateEditText(String title,String album,String artist , String path);
        void setSongList(List<String> allAudio);
        //void setSongDetails(List<String> songDetails);
    }
    //for nowPlayingFragment
    interface NowPlayingView {
        void setSongDetails(List<String> songDetails);

        void setProgress(int currentPosition);

        void setMax(int totalDuration);
    }
}
