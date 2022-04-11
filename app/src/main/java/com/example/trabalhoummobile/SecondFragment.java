package com.example.trabalhoummobile;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.trabalhoummobile.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private MediaPlayer mediaPlayer;
    private boolean isInital = true;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        Spinner spinner = (Spinner) binding.spinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.sounds_array, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                }

                if(isInital){
                    isInital = false;
                    return;
                }

                switch (position){
                    case 0:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.claps);
                        mediaPlayer.start();
                        break;
                    case 1:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.digitalbell);
                        mediaPlayer.start();
                        break;
                    case 2:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.estalardedos);
                        mediaPlayer.start();
                        break;
                    case 3:
                        mediaPlayer = MediaPlayer.create(getContext(), R.raw.vibracaocelul);
                        mediaPlayer.start();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }

        binding = null;
    }

}