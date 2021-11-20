package com.example.project_media_02;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NowPlaying_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NowPlaying_Fragment extends Fragment {
    private final MediaControllerCompat.Callback mediaControllerCallback = new MediaControllerCompat.Callback() {
        @Override
        public void onPlaybackStateChanged(PlaybackStateCompat state) {
            super.onPlaybackStateChanged(state);
        }

        @Override
        public void onMetadataChanged(MediaMetadataCompat metadata) {
            super.onMetadataChanged(metadata);
        }
    };

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NowPlaying_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NowPlaying_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NowPlaying_Fragment newInstance(String param1, String param2) {
        NowPlaying_Fragment fragment = new NowPlaying_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    //    private View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            //MediaControllerCompat.TransportControls controls = MediaControllerCompat.getMediaController(getActivity()).getTransportControls();
//
//
//            switch (view.getId()) {
//                case R.id.fr_now_playing_ib_playpause:
//                    play();
////                    PlaybackStateCompat state = MediaControllerCompat.getMediaController(NowPlaying_Fragment.this.getActivity()).getPlaybackState();
////
////                    if (state != null) {
////                        switch (state.getState()) {
////                            case PlaybackStateCompat.STATE_PLAYING:
////                            case PlaybackStateCompat.STATE_BUFFERING:
////                                controls.pause();
////                                break;
////                            case PlaybackStateCompat.STATE_PAUSED:
////                            case PlaybackStateCompat.STATE_STOPPED:
////                                controls.play();
////                                break;
////
////                        }
////                    }
//                    Toast.makeText(getActivity(), "Play Music", Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.fr_now_playing_ib_next:
//                    //controls.skipToNext();
//                    Toast.makeText(getActivity(), "Play Next Music", Toast.LENGTH_LONG).show();
//                    break;
//
//                case R.id.fr_now_playing_ib_previous:
//                    //controls.skipToPrevious();
//                    Toast.makeText(getActivity(), "Play Previous Music", Toast.LENGTH_LONG).show();
//                    break;
//
//                default:
//                    break;
//
//            }
//        }
//
//        private void play() {
//        }
//
//    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_now_playing_, container, false);

//        TextView textView_SongName = (TextView) v.findViewById(R.id.fr_now_playing_tv_songname);
//        TextView textView_Album = (TextView) v.findViewById(R.id.fr_now_playing_tv_album);
//        TextView textView_Artist = (TextView) v.findViewById(R.id.fr_now_playing_tv_artist);
//        ImageButton imageButton_Previous = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_previous);
//        ImageButton imageButton_PlayPause = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_playpause);
//        ImageButton imageButton_Next = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_next);
//        Drawable PlayDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_play_arrow_24);
//        Drawable PauseDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_pause_24);
//
//
//        imageButton_PlayPause.setOnClickListener(onClickListener);
//        imageButton_Next.setOnClickListener(onClickListener);
//        imageButton_Previous.setOnClickListener(onClickListener);


       return v;

    }




//    private View.OnClickListener onClickListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//            switch (view.getId()) {
//                case R.id.fr_now_playing_ib_playpause:
//
//                    PlaySong();
//
//                     break;
//
//                case R.id.fr_now_playing_ib_next:
//                     NextSong();
//                     Toast.makeText(getActivity(), "Play Next Music", Toast.LENGTH_LONG).show();
//                     break;
//
//                case R.id.fr_now_playing_ib_previous:
//                     PreviousSong();
//                     Toast.makeText(getActivity(), "Play Previous Music", Toast.LENGTH_LONG).show();
//                     break;
//
//                default:
//                     break;
//
//
//            }
//        }
//
//
//
//    };
//
//    private void PlaySong() {
//        Log.d("Play:","playsong");
//
//    }
//
//    private void NextSong() {
//
//    }
//
//    private void PreviousSong() {
//
//    }

}


