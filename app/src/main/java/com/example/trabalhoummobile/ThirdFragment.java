package com.example.trabalhoummobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.trabalhoummobile.databinding.FragmentSecondBinding;
import com.example.trabalhoummobile.databinding.FragmentThirdBinding;

import java.util.ArrayList;
import java.util.List;


public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        int drawablesSize = 15;
        int list[] = new int[]{
            R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7, R.drawable.sample_8,
            R.drawable.sample_9, R.drawable.sample_10
        };

        binding.gridView.setAdapter(new Adapter(getContext(), list));
        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String breed;
                switch (position){
                    case 0:
                        breed = "Bulldog";
                        break;
                    case 1:
                        breed = "Poodle";
                        break;
                    case 2:
                        breed = "Labrador";
                        break;
                    case 3:
                        breed = "Beagle";
                        break;
                    case 4:
                        breed = "Chihuahua";
                        break;
                    case 5:
                        breed = "Maltês";
                        break;
                    case 6:
                        breed = "Pastor Alemão";
                        break;
                    case 7:
                        breed = "Pug";
                        break;
                    case 8:
                        breed = "Husky Siberiano";
                        break;
                    case 9:
                        breed = "Lhasa apso";
                        break;
                    case 10:
                        breed = "Pinscher";
                        break;
                    default:
                        breed = "SRD";
                        break;
                }

                binding.textView.setText("Você selecionou um " + breed + "!");
            }
        });
     }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}