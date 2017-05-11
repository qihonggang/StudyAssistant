package com.example.studyassistant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.studyassistant.R;

public class HomeTown3Fragment extends Fragment {


    ImageView iv_keting,iv_woshi,iv_canting,iv_shufang,iv_ertongfang,iv_qita;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hometown_space,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
    }

    private void setupViews(View view) {

        iv_keting = (ImageView) view.findViewById(R.id.iv_keting);
        iv_woshi = (ImageView) view.findViewById(R.id.iv_woshi);
        iv_canting = (ImageView) view.findViewById(R.id.iv_canting);
        iv_shufang = (ImageView) view.findViewById(R.id.iv_shufang);
        iv_ertongfang = (ImageView) view.findViewById(R.id.iv_ertongfang);
        iv_qita = (ImageView) view.findViewById(R.id.iv_qita);
    }


}