package com.example.studyassistant.fragments;


import android.graphics.Color;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.studyassistant.R;
import com.example.studyassistant.adapter.HomeTownAdapter;


public class HomeTownFragment extends Fragment implements View.OnClickListener {

    ViewPager viewPager;
    //声明数据
//    List<View> views;

    //标题的父布局
    LinearLayout title_layout;

    //小滑块
    View slip;

    String[] titles = {"空间", "全屋"};

    //水平滚动条
    HorizontalScrollView scrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hometown, container, false);

        //初始化数据源和Adapter
        initData();


        //找到控件
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        title_layout = (LinearLayout) view.findViewById(R.id.title_layout);
        slip = view.findViewById(R.id.slip);
        scrollView = (HorizontalScrollView) view.findViewById(R.id.scrollView);

        //标题
        initTittle();

//        MyAdapter adapter = new MyAdapter();
//        viewPager.setAdapter(adapter);
        setListener();
        return view;
    }



    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //小滑块滑动到当前标题下方，通过设置marginLeft来实现
                //先获取slip的布局属性
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) slip.getLayoutParams();
                //设置marginLeft
                params.leftMargin = (int) ((position + positionOffset) * params.width);
                slip.setLayoutParams(params);

                //设置滚动条的滚动距离
                scrollView.scrollTo(params.leftMargin - params.width * 3, 0);
            }

            //页面切换成功时调用，position指的是当前正在显示的Fragment的下标
            @Override
            public void onPageSelected(int position) {
                //获取标题布局中所有子控件的个数
                int childCount = title_layout.getChildCount();
                //循环获取每一个TextView
                for (int i = 0; i < childCount; i++) {
                    TextView tv = (TextView) title_layout.getChildAt(i);
                    //设置TextView的文字颜色
                    if (i == position) {
                        //选中项
                        tv.setTextColor(Color.BLACK);
                    } else {
                        tv.setTextColor(Color.GRAY);
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initTittle() {
        //获取标题内容长度
        int len = titles.length;
        //屏幕宽度
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        //TextView的布局属性，宽度为屏幕的1/6，高度MatchParent
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(screenWidth / 8,
                LinearLayout.LayoutParams.MATCH_PARENT);


        //循环创建TextView
        for (int i = 0; i < len; i++) {
            TextView tv = new TextView(getActivity());
            //文本内容
            tv.setText(titles[i]);
            //内容居中
            tv.setGravity(Gravity.CENTER);
            //设置文字大小为20dp
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            //文本颜色
            if (i == 0) {
                tv.setTextColor(Color.BLACK);
            } else {
                tv.setTextColor(Color.GRAY);
            }
            //设置Tag
            tv.setTag(i);
            //监听事件
            tv.setOnClickListener(this);
            //添加标题到布局中

            title_layout.addView(tv, params);
        }

        // 设置小滑块的宽度，小滑块已经存在于布局中
        //先获取slip的布局属性
        LinearLayout.LayoutParams slipParams = (LinearLayout.LayoutParams) slip.getLayoutParams();
        //再设置他的布局属性的宽度
        slipParams.width = screenWidth / 8;
        //再把这个属性设置回去
        slip.setLayoutParams(slipParams);
    }


    private void initData() {
//        views = new ArrayList<>();
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        //----------第一个界面
//        View view1 = inflater.inflate(R.layout.fragment_hometown_space, null);
//        views.add(view1);
//        //----------第二个界面
//        View view2 = inflater.inflate(R.layout.fragment_hometown_allhouse, null);
//        views.add(view2);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    HomeTownAdapter adapter;
    private void init(View view) {
        adapter=new HomeTownAdapter(getChildFragmentManager(),titles);
        viewPager.setAdapter(adapter);
//        for (int i = 0; i < titles.length; i++) {
//        tab.addTab(tab.newTab().setText(titles[i]));
//    }
//
//    tab.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View view) {
        //标题点击，ViewPager显示标题对应的项
        //取出标题的Tag
        int index = (int) view.getTag();
        //ViewPager显示指定项
        viewPager.setCurrentItem(index);
    }


    /**
     * Adapter
     */
//    class MyAdapter extends PagerAdapter {
//
//        //返回View的个数
//        @Override
//        public int getCount() {
//            return views.size();
//        }
//
//        //完成两件事：
//        /*
//        * 一.加载View
//        *
//        * 二。返回当前被加载的View
//        *
//        * 参数一：ViewGroup:加载View的父控件
//        *
//        * 参数二：int   :当前被加载的View在数据源中的位置
//        * */
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//
//            //加载position位置的 View
//            container.addView(views.get(position));
//            //返回刚被加载的View
//
//            return views.get(position);
//
//        }
//
//        //移除不使用的View
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            //写法一：
////           container.removeView(views.get(position));
//            //写法二：
//            container.removeView((View) object);
//        }
//
//
//        //判断instantiateItem返回的object是不是view
//        @Override
//        public boolean isViewFromObject(View view, Object object) {
//            return view == object;
//        }
//    }
}

