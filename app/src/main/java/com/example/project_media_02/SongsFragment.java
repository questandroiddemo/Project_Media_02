package com.example.project_media_02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.project_media_02.ContractInterface.Contract;
import com.example.project_media_02.Presenter.Presenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SongsFragment extends Fragment implements Contract.View{

    Presenter presenter;
    RecyclerView recyclerView;
    MusicAdapter musicAdapter;

    public SongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        presenter = new Presenter(this);
        presenter.getAllAudio();
        return view;
    }

    @Override
    public void setSongList(List<String> allAudio) {
        System.out.println("inside setSongList"+allAudio);
        musicAdapter = new MusicAdapter(getContext(),allAudio);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(musicAdapter);
    }
}