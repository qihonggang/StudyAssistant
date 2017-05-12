package com.example.studyassistant.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyassistant.R;
import com.example.studyassistant.fragments.GoodFragment;
import com.example.studyassistant.fragments.HomeTownFragment;
import com.example.studyassistant.fragments.MineFragment;


public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {

    //底部导航文字
    private String[] tabText = {
            "线下", "线上", "学友圈", "我的"
    };

    //底部导航图片id数组
    private int[] imgIds = {
            R.drawable.tab_word_sel,
            R.drawable.tab_hometown_sel,
            R.drawable.tab_good_sel,
            R.drawable.tab_mine_sel
    };

    //TabHost使用的Fragment数组
    Class[] fragments = {
            GoodFragment.class, HomeTownFragment.class, GoodFragment.class, MineFragment.class
    };

    //控件声明
    private FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化方法
        setupViews();
    }

    LayoutInflater inflater;

    private void setupViews() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);


        //设置tabHost
        tabHost.setup(this, getSupportFragmentManager(), R.id.fragmentLayout);
        inflater = LayoutInflater.from(this);

        //给tabHost添加Tab
        for (int i = 0; i < tabText.length; i++) {

            //创建新的Tab
            TabHost.TabSpec tabItem = tabHost.newTabSpec(i + "");
            //给tabItem设置内容
            tabItem.setIndicator(getTabItemView(i));
            //把tabItem添加到TabHost中
            tabHost.addTab(tabItem, fragments[i], null);
        }
        tabHost.setCurrentTab(1);
        tabHost.setOnTabChangedListener(this);
    }


    /**
     * 加载底部导航的四个Tab
     *
     * @param index
     * @return
     */
    private View getTabItemView(int index) {
        View view = inflater.inflate(R.layout.tab_item_layout, null);
        //拿到控件中的值
        ImageView iv = (ImageView) view.findViewById(R.id.tab_img);
        //设置图片
        iv.setImageResource(imgIds[index]);
        TextView tv = (TextView) view.findViewById(R.id.tab_tv);
        tv.setText(tabText[index]);
        return view;
    }


    /**
     * 按两次退出
     */
    long mExitTime;

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "真的要离开我么(ಥ _ ಥ)", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();

            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals("2")){
            startActivity(new Intent(MainActivity.this,LineActivity.class));
            tabHost.setCurrentTab(1);
        }
    }
}

