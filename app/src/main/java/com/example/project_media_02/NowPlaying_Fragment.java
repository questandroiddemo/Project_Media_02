package com.example.project_media_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_now_playing_, container, false);

        TextView textView_SongName = (TextView) v.findViewById(R.id.fr_now_playing_tv_songname);
        TextView textView_Album = (TextView) v.findViewById(R.id.fr_now_playing_tv_album);
        TextView textView_Artist = (TextView) v.findViewById(R.id.fr_now_playing_tv_artist);
        ImageButton imageButton_Previous = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_previous);
        ImageButton imageButton_PlayPause = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_playpause);
        ImageButton imageButton_Next = (ImageButton) v.findViewById(R.id.fr_now_playing_ib_next);


        imageButton_Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPrevious();
            }
        });

        imageButton_PlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performPlayPause();
            }
        });

        imageButton_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNext();
            }
        });

      return v;
    }


    //********* Service App *********

    private void performNext() {
        Toast.makeText(getActivity(),"Previous Button Pressed",Toast.LENGTH_SHORT).show();
    }

    private void performPlayPause() {
        Toast.makeText(getActivity(),"PlayPause Button Pressed",Toast.LENGTH_SHORT).show();
    }

    private void performPrevious() {
        Toast.makeText(getActivity(),"Next Button Pressed",Toast.LENGTH_SHORT).show();
    }
}