package com.example.project_media_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.project_media_02.View.ContractView;
import com.example.project_media_02.Presenter.Presenter;

import java.util.List;

public class NowPlayingFragment extends Fragment implements ContractView.NowPlayingView {
    Presenter presenter;

    static TextView title1,album1,artist1;
    static ImageView imageView;
    static SeekBar songSeekBar;
    static ImageButton btn_play_pause,btn_previous,btn_next;
    View v;
    boolean playStatus;

    public NowPlayingFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_now_playing, container, false);
        title1=v.findViewById(R.id.text);
        album1=v.findViewById(R.id.album);
        artist1=v.findViewById(R.id.artist);
        songSeekBar=v.findViewById(R.id.songSeekBar);
        imageView=v.findViewById(R.id.imageView);
        btn_play_pause=v.findViewById(R.id.fr_nowplaying_ib_play_pause);
        btn_next=v.findViewById(R.id.fr_nowplaying_ib_next);
        btn_previous=v.findViewById(R.id.fr_nowplaying_ib_previous);
        presenter = new Presenter();

        try {
            presenter.getSongDetails(0);
                presenter.playSong(0);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getContext(),"No Audio files",Toast.LENGTH_SHORT).show();
        }
        btn_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playStatus= presenter.PlayPauseButtonClick();
                System.out.println("playpause onclick called");
                if(playStatus==true) {
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                }
                else {
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
                }

            }
        });

        // Next Button click
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.NextClick();

            }
        });

        //On seekBar Drag
        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                presenter.seekToCall(seekBar.getProgress());
            }
        });


        // Previous Button click
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PreviousClick();
            }
        });

        return v;
    }
    @Override
    public void setProgress(int currentPosition) {
        songSeekBar.setProgress(currentPosition);
    }

    @Override
    public void setMax(int totalDuration) {
            songSeekBar.setMax(totalDuration);
    }

    @Override
    public void setSongDetails(List<String> songDetails) {
        System.out.println("call reached to setSongDetails in nowPlaying");
        System.out.println("songDetails.get(0)  value " +songDetails.get(0));
        title1.setText("Song Name   :   "+songDetails.get(0));
        album1.setText("Album   :   "+songDetails.get(1));
        artist1.setText("Artist   :   "+songDetails.get(2));
        imageView.setImageResource(R.drawable.images);
        btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        playStatus = true;
    }
}