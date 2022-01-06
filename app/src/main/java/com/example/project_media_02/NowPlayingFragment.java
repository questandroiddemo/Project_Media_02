package com.example.project_media_02;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.project_media_02.View.ContractView;
import com.example.project_media_02.Presenter.Presenter;

import java.util.List;

public class NowPlayingFragment extends Fragment implements ContractView.NowPlayingView {
    Presenter presenter;

    static TextView title1,album1,artist1,totalDuration,playerPosition;
    static ImageView imageView;
    static ImageButton btn_play_pause,btn_previous,btn_next;
    static SeekBar songSeekBar;
    View v;
    boolean playStatus;
    int cPosition=0;

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
        totalDuration=v.findViewById(R.id.totalDuration);
        playerPosition=v.findViewById(R.id.playerPosition);
        imageView=v.findViewById(R.id.imageView);
        btn_play_pause=v.findViewById(R.id.fr_nowplaying_ib_play_pause);
        btn_next=v.findViewById(R.id.fr_nowplaying_ib_next);
        btn_previous=v.findViewById(R.id.fr_nowplaying_ib_previous);
        songSeekBar=v.findViewById(R.id.songSeekBar);
        presenter = new Presenter();

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

        // Previous Button click
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PreviousClick();
            }
        });

        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //
                System.out.println("progress value"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("onStopTrackingTouch "+seekBar.getProgress());
                presenter.seekToCall(seekBar.getProgress());
                //mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


        return v;
    }

    @Override
    public void setSongDetails(List<String> songDetails) {
        System.out.println("call reached to setSongDetails in nowPlaying");
        System.out.println("songDetails.get(0)  value " +songDetails.get(0));
        title1.setText("Song name   :   "+songDetails.get(0));
        album1.setText("album   :   "+songDetails.get(1));
        artist1.setText("Artist   :   "+songDetails.get(2));
        String duration = convert(songDetails.get(4));//to convert total duration into minutes and seconds
        totalDuration.setText(duration);

        String uri = songDetails.get(5);
        if(uri!=null) {
//
            imageView.setImageResource(R.drawable.images);
        }
        else
        {
            imageView.setImageResource(R.drawable.images);
        }

        btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        playStatus = true;
    }

    private String convert(String time) {
        int milliseconds= Integer.parseInt(time);
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    @Override
    public void setProgress(int currentPosition) {
        songSeekBar.setProgress(currentPosition);
        // playerPosition.setText(String.valueOf(currentPosition));
    }

    @Override
    public void setMax(int totalDuration) {
        songSeekBar.setMax(totalDuration);
    }

}