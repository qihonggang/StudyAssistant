package com.example.studyassistant.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.studyassistant.R;
import com.example.studyassistant.ui.activity.WebStudyActivity;

public class HomeTown3Fragment extends Fragment {


    ImageView iv_mooc,iv_imooc,iv_tenxunketang,iv_coursera,iv_wangyiyun,iv_xuetang;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hometown_space,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
        setListener();
    }

    private void setupViews(View view) {

        iv_mooc = (ImageView) view.findViewById(R.id.iv_mooc);
        iv_imooc = (ImageView) view.findViewById(R.id.iv_imooc);
        iv_tenxunketang = (ImageView) view.findViewById(R.id.iv_tenxunketang);
        iv_coursera = (ImageView) view.findViewById(R.id.iv_coursera);
        iv_wangyiyun = (ImageView) view.findViewById(R.id.iv_wangyiyun);
        iv_xuetang = (ImageView) view.findViewById(R.id.iv_xuetang);
        setListener();
    }

    private void setListener(){
        iv_mooc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","mooc");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        iv_imooc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","imooc");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        iv_tenxunketang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","tenxunketang");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        iv_coursera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","coursera");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        iv_wangyiyun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","wangyiyun");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        iv_xuetang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WebStudyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url","xuetang");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}