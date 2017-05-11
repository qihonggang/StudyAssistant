package com.example.studyassistant.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.studyassistant.R;
import com.example.studyassistant.adapter.AbsBaseAdapter;
import com.example.studyassistant.bean.WorldBean;
import com.example.studyassistant.interfaces.IWorldInterface;
import com.example.studyassistant.ui.activity.MainActivity;
import com.example.studyassistant.ui.activity.WorldDetailActivity;
import com.example.studyassistant.utils.APIManager;
import com.example.studyassistant.widget.PullToRefshHwadView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class WorldFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView lv;

    //刷新控件

    PtrFrameLayout refresh;

    //数据源
    List<WorldBean.DataBean.RowsBean> data;
    //Adapter
    AbsBaseAdapter<WorldBean.DataBean.RowsBean> adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化数据源和Adapter
        initData();
        getData();

    }

    //    ImageView iv;
    private void initData() {

        data = new ArrayList<>();
        adapter = new AbsBaseAdapter<WorldBean.DataBean.RowsBean>(getActivity(), data, R.layout.world_list_item) {
            @Override
            public void bindData(int position, ViewHolder holder) {


                //绑定数据
                WorldBean.DataBean.RowsBean bean = data.get(position);

                //图片
                ImageView iv = (ImageView) holder.findViewById(R.id.iv);
                Glide.with(WorldFragment.this).load(bean.getPoster_img()).into(iv);

                //标题
                TextView tvTitle = (TextView) holder.findViewById(R.id.tv_tittle);

                tvTitle.setText(bean.getTitle());
                //种类
                TextView tvName = (TextView) holder.findViewById(R.id.tv_name);

                tvName.setText(bean.getClass_name());
            }

        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_world, container, false);
        //初始化数据源和Adapter
//        initData();
        //初始化控件
//        setupViews(view);
//        getData();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);

    }

    private void setupViews(View view) {

        lv = (ListView) view.findViewById(R.id.lv);

        lv.setAdapter(adapter);


        lv.setOnItemClickListener(this);
        //初始化刷新控件

        setupRefreshView(view);
    }

    private void setupRefreshView(View view) {
        refresh = (PtrFrameLayout) view.findViewById(R.id.refresh);
        //==================UI=======================
        //创建刷新头
        PullToRefshHwadView pullHead = new PullToRefshHwadView(getActivity());
        //添加刷新头
        refresh.setHeaderView(pullHead);
        //添加刷新头控制
        refresh.addPtrUIHandler(pullHead);
        //=======================功能部分
        //设置刷新事件
        refresh.setPtrHandler(new PtrDefaultHandler() {
            //刷新方法
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //刷新代码
                getData();
            }

            //解决ListView与下拉刷新的冲突
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return super.checkCanDoRefresh(frame, lv, header);
            }
        });

    }

    private void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.BASE)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();


        //创建接口对象
        IWorldInterface iworld = retrofit.create(IWorldInterface.class);

//        Call<WorldBean> call = iworld.getList();

        Call<String> call = iworld.getList();
        /*call.enqueue(new Callback<WorldBean>() {
            @Override
            public void onResponse(Call<WorldBean> call, Response<WorldBean> response) {
                WorldBean body = response.body();
                List<WorldBean.DataBean.RowsBean> rows = body.getData().getRows();
                for (int i = 0; i < rows.size(); i++) {
                    String title = rows.get(i).getTitle();
                    String poster_img = rows.get(i).getPoster_img();
                    String class_name = rows.get(i).getClass_name();
                }
            }

            @Override
            public void onFailure(Call<WorldBean> call, Throwable t) {

            }
        });*/
        //发请求
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String value = response.body();
                Log.d("TAG", "``````" + value);
                //把String解析成Bean
                Gson gson = new Gson();
                WorldBean bean = gson.fromJson(value, new TypeToken<WorldBean>() {
                }.getType());

                //得到bean中的集合
                data.clear();
                data.addAll(bean.getData().getRows());
                //通知更新界面
                adapter.notifyDataSetChanged();
                //结束刷新
                refresh.refreshComplete();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //结束刷新
                refresh.refreshComplete();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getActivity(),WorldDetailActivity.class);
        startActivity(intent);
    }


}