package com.example.studyassistant.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.studyassistant.R;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;


public class MineFragment extends Fragment {
    Button button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = (Button) view.findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareSDK.initSDK(getActivity());
                Platform[] plaforms = ShareSDK.getPlatformList();
                for (Platform plaform : plaforms){
                    plaform.removeAccount(true);
                }
                System.exit(0);
                }
            });
        }

}
