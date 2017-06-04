package com.example.studyassistant.ui.activity;

import android.os.Bundle;

import net.datafans.android.timeline.controller.UserTimelineViewController;
import net.datafans.android.timeline.item.user.BaseUserLineItem;
import net.datafans.android.timeline.item.user.TextImageUserLineItem;

public class UserFeedActivity extends UserTimelineViewController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        addItems();
        super.onCreate(savedInstanceState);


        setHeader();
    }

    @Override
    protected String getNavTitle() {
        return "Alan的相册";
    }


    private void setHeader() {
        String coverUrl = String.format("http://onpq82ecm.bkt.clouddn.com/scene6.jpg", coverWidth, coverHeight);
        setCover(coverUrl);


        String userAvatarUrl = String.format("http://onpq82ecm.bkt.clouddn.com/mine.jpg", userAvatarSize, userAvatarSize);
        setUserAvatar(userAvatarUrl);


        setUserNick("Alan");

        setUserSign("梦想还是要有的 万一实现了呢");

        setUserId(123456);
    }



    private void addItems() {

        TextImageUserLineItem item = new TextImageUserLineItem();
        item.itemId = 1111;
        item.ts = 1444902955586L;
        item.cover = "http://onpq82ecm.bkt.clouddn.com/scene9.jpg";
        item.text = "一起加入学友圈吧";
        addItem(item);


        TextImageUserLineItem item2 = new TextImageUserLineItem();
        item2.itemId = 11222;
        item2.ts = 1444902951586L;
        item2.text = "我们可以使用学有圈来提高学习效率。";

        addItem(item2);


        TextImageUserLineItem item3 = new TextImageUserLineItem();
        item3.itemId = 22221111;
        item3.ts = 1444102855586L;
        item3.cover = "http://onpq82ecm.bkt.clouddn.com/scene10.jpg";
        addItem(item3);


        TextImageUserLineItem item4 = new TextImageUserLineItem();
        item4.itemId = 7771111;
        item4.ts = 1442912955586L;
        item4.cover = "http://onpq82ecm.bkt.clouddn.com/scene8.jpg";

        addItem(item4);


        TextImageUserLineItem item5 = new TextImageUserLineItem();
        item5.itemId = 9991111;
        item5.ts = 1442912945586L;
        item5.cover = "http://onpq82ecm.bkt.clouddn.com/scene7.jpg";
        item5.text = "我好像爱上学习了";
        addItem(item5);


    }


    @Override
    public void onRefresh() {
        super.onRefresh();

        onEnd();
    }


    @Override
    public void onLoadMore() {
        super.onLoadMore();

        onEnd();
    }

    @Override
    public void onClickItem(BaseUserLineItem item) {

    }
}
