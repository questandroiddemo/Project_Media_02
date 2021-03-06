package com.example.project_media_02.View;

import java.util.List;

public interface ContractView {

    //for songListFragment
    interface View{
        void setSongList(List<String> allAudio);
    }

    //for nowPlayingFragment
    interface NowPlayingView{
        void setProgress(int currentPosition);

        void setMax(int totalDuration);

        void setSongDetails(List<String> songDetails);
    }

}
