package com.example.project_media_02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Model.MusicModel;
import com.example.project_media_02.Presenter.ActivityPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NowPlaying_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NowPlaying_Fragment extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String path;
    String nam; String album; String artist;

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
        bindToAIDLService();
    }

    private void bindToAIDLService() {

    }

    Contract.Presenter presenter = new ActivityPresenter((Contract.View) getActivity(),this,new MusicModel());





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_now_playing_, container, false);

       // presenter = new ActivityPresenter ( (Contract.View)getActivity (),this,new MusicModel ());
        TextView textView_SongName = v. findViewById(R.id.fr_nowplaying_tv_songname);
        TextView textView_Album = v. findViewById(R.id.fr_nowplaying_tv_album);
        TextView textView_Artist = v. findViewById(R.id.fr_nowplaying_tv_artist);
        ImageButton imageButton_Previous = v. findViewById(R.id.fr_nowplaying_ib_previous);
        ImageButton imageButton_Play_pause = v. findViewById(R.id.fr_nowplaying_ib_play_pause);
        ImageButton imageButton_Next = v. findViewById(R.id.fr_nowplaying_ib_next);


        imageButton_Previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.PlayPreviousButtonClick();


            }
        });


        imageButton_Play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              // SingleTon.getInstance().PlayCurrentSong();
               presenter.PlayCurrentButtonClick();

            }
        });


        imageButton_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.PlayNextButtonClick();


            }
        });




      return v;

    }




}