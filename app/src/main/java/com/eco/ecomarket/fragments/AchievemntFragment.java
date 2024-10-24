package com.eco.ecomarket.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eco.ecomarket.Controller.GetStarted;
import com.eco.ecomarket.R;

public class AchievemntFragment extends Fragment {

    public AchievemntFragment() {
        // Required empty public constructor
    }
    Button btn_bronze;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_achievemnt, container, false);

        return view;
    }


}