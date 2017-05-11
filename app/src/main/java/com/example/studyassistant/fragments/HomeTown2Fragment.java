package com.example.studyassistant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.studyassistant.R;
import com.example.studyassistant.adapter.AbsBaseAdapter;
import com.example.studyassistant.bean.HomeBean;
import com.example.studyassistant.interfaces.IWorldInterface;
import com.example.studyassistant.utils.APIManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HomeTown2Fragment extends Fragment {
    public static final ArrayList<? extends HomeBean.DataBean.RowsBean> ROWS_BEEN = new ArrayList<>();
    ListView lv;

    //数据源
    List<HomeBean.DataBean.RowsBean> data;
    AbsBaseAdapter<HomeBean.DataBean.RowsBean> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();
        getData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hometown_allhouse, container, false);

        //初始化数据源和Adapter
//        initData();

//        lv = (ListView) view.findViewById(R.id.lv);
//
//        lv.setAdapter(adapter);
//        getData();
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ListView) view.findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

    private void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        //创建接口对象
        IWorldInterface iworld = retrofit.create(IWorldInterface.class);

        Call<String> call = iworld.getQuan();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String value = response.body();
                Log.d("TAG", "``````" + value);
                //把String解析成Bean
                Gson gson = new Gson();
                HomeBean bean = gson.fromJson(value, new TypeToken<HomeBean>() {
                }.getType());

                //得到bean中的集合
                data.clear();
                data.addAll(bean.getData().getRows());
                //通知更新界面
                adapter.notifyDataSetChanged();
                //结束刷新
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }

    private void initData() {

        data = new ArrayList<>();
        adapter = new AbsBaseAdapter<HomeBean.DataBean.RowsBean>(getActivity(),data,R.layout.hometown_list_item) {
            @Override
            public void bindData(int position, ViewHolder holder) {
                //绑定数据
                HomeBean.DataBean.RowsBean bean = data.get(position);

                //图片
                ImageView iv = (ImageView) holder.findViewById(R.id.iv);
                Glide.with(HomeTown2Fragment.this).load(bean.getImg_url()).into(iv);

                //标题
                TextView tvTitle = (TextView) holder.findViewById(R.id.tv_name);

                tvTitle.setText(bean.getName());
//                //种类
//                TextView tvName = (TextView) holder.findViewById(R.id.tv_name);
//
//                tvName.setText(bean.getTags());

            }
        };
    }
}
