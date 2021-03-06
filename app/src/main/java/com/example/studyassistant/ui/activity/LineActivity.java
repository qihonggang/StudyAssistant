package com.example.studyassistant.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import net.datafans.android.common.helper.LogHelper;
import net.datafans.android.timeline.controller.TimelineViewController;
import net.datafans.android.timeline.item.LineCommentItem;
import net.datafans.android.timeline.item.LineItemType;
import net.datafans.android.timeline.item.LineLikeItem;
import net.datafans.android.timeline.item.TextImageLineItem;

public class LineActivity extends TimelineViewController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        addItems();

        super.onCreate(savedInstanceState);

        LogHelper.init("## timeline ##", true);

        setHeader();

    }

    @Override
    protected String getNavTitle() {

        return "学友圈";
    }


    private void setHeader() {
        String coverUrl = String.format("http://onpq82ecm.bkt.clouddn.com/scene8.jpg", coverWidth, coverHeight);
        setCover(coverUrl);


        String userAvatarUrl = String.format("http://onpq82ecm.bkt.clouddn.com/mine.jpg", userAvatarSize, userAvatarSize);
        setUserAvatar(userAvatarUrl);


        setUserNick("Alan");

        setUserSign("梦想还是要有的 万一实现了呢");

        setUserId(123456);
    }

    private TextImageLineItem textImageItem3;

    private void addItems() {

        TextImageLineItem textImageItem = new TextImageLineItem();
        textImageItem.itemId = 1;
        textImageItem.itemType = LineItemType.TextImage;
        textImageItem.userId = 10086;
        textImageItem.userAvatar = "http://onpq82ecm.bkt.clouddn.com/mine.jpg";
        textImageItem.userNick = "Alan";
        textImageItem.title = "";
        textImageItem.text = "我爱学习，一起来用学习助手[亲亲]";
        textImageItem.srcImages.add("http://onpq82ecm.bkt.clouddn.com/scene2.jpg");
        textImageItem.thumbImages.add("http://onpq82ecm.bkt.clouddn.com/scene2.jpg");
        textImageItem.location = "中国 •  北京";
        textImageItem.ts = System.currentTimeMillis() - 10 * 60 * 1000;
        LineLikeItem likeItem1_1 = new LineLikeItem();
        likeItem1_1.userId = 10086;
        likeItem1_1.userNick = "Alan";
        textImageItem.likes.add(likeItem1_1);
        LineLikeItem likeItem1_2 = new LineLikeItem();
        likeItem1_2.userId = 10088;
        likeItem1_2.userNick = "特朗普";
        textImageItem.likes.add(likeItem1_2);
        LineCommentItem commentItem1_1 = new LineCommentItem();
        commentItem1_1.commentId = 1000;
        commentItem1_1.userId = 10086;
        commentItem1_1.userNick = "习大大";
        commentItem1_1.text = "小伙子 有前途";
        textImageItem.comments.add(commentItem1_1);
        LineCommentItem commentItem1_2 = new LineCommentItem();
        commentItem1_2.commentId = 100980;
        commentItem1_2.userId = 10088;
        commentItem1_2.userNick = "特朗普";
        commentItem1_2.text = "推特治国 我可是首创啊";
        commentItem1_2.replyUserId = 10086;
        commentItem1_2.replyUserNick = "习大大";
        textImageItem.comments.add(commentItem1_2);
        LineCommentItem commentItem1_3 = new LineCommentItem();
        commentItem1_3.commentId = 456567;
        commentItem1_3.userId = 10010;
        commentItem1_3.userNick = "普金";
        commentItem1_3.text = "不错";
        textImageItem.comments.add(commentItem1_3);
        addItem(textImageItem);


        TextImageLineItem textImageItem2 = new TextImageLineItem();
        textImageItem2.itemId = 2;
        textImageItem2.itemType = LineItemType.TextImage;
        textImageItem2.userId = 10088;
        textImageItem2.userAvatar = "http://onpq82ecm.bkt.clouddn.com/person1.jpg";
        textImageItem2.userNick = "特朗普";
        textImageItem2.title = "发表了";
        textImageItem2.text = "中国发展真快，牛！！";
        textImageItem2.srcImages.add("http://onpq82ecm.bkt.clouddn.com/scene3.jpg");

        textImageItem2.thumbImages.add("http://onpq82ecm.bkt.clouddn.com/scene3.jpg");

        textImageItem2.ts = System.currentTimeMillis() - 300 * 60 * 1000;
        LineLikeItem likeItem2_1 = new LineLikeItem();
        likeItem2_1.userId = 10086;
        likeItem2_1.userNick = "Alan";
        textImageItem2.likes.add(likeItem2_1);
        LineCommentItem commentItem2_1 = new LineCommentItem();
        commentItem2_1.commentId = 31000;
        commentItem2_1.userId = 10088;
        commentItem2_1.userNick = "奥巴马";
        commentItem2_1.text = "欢迎来到美利坚";
        commentItem2_1.replyUserId = 10086;
        commentItem2_1.replyUserNick = "习大大";
        textImageItem2.comments.add(commentItem2_1);
        LineCommentItem commentItem2_2 = new LineCommentItem();
        commentItem2_2.commentId = 166000;
        commentItem2_2.userId = 10010;
        commentItem2_2.userNick = "普金";
        commentItem2_2.text = "还是学习助手好用";
        textImageItem2.comments.add(commentItem2_2);
        addItem(textImageItem2);


        textImageItem3 = new TextImageLineItem();
        textImageItem3.itemId = 3;
        textImageItem3.itemType = LineItemType.TextImage;
        textImageItem3.userId = 10088;
        textImageItem3.userAvatar = "http://onpq82ecm.bkt.clouddn.com/person2.jpg";
        textImageItem3.userNick = "普金";
        textImageItem3.title = "发表了";
        textImageItem3.text = "我喜欢学习助手，我要向我的国民推荐使用。";
        textImageItem3.srcImages.add("http://onpq82ecm.bkt.clouddn.com/scene4.jpg");
        textImageItem3.thumbImages.add("http://onpq82ecm.bkt.clouddn.com/scene4.jpg");
        textImageItem3.ts = System.currentTimeMillis() - 3000 * 60 * 1000;
        textImageItem3.location = "俄罗斯";
        addItem(textImageItem3);
    }


    @Override
    public void onRefresh() {
        super.onRefresh();

        onEnd();

    }


    @Override
    public void onLoadMore() {
        super.onLoadMore();


        addItem(textImageItem3);

        onEnd();

    }

    @Override
    protected void onCommentCreate(long itemId, long commentId, String text) {

        LineCommentItem commentItem = new LineCommentItem();
        commentItem.commentId = System.currentTimeMillis();
        commentItem.userId = 10014;
        commentItem.userNick = "Alan";
        commentItem.text = text;
        addCommentItem(commentItem, itemId, commentId);
    }

    @Override
    protected void onLikeCreate(long itemId) {
        LineLikeItem likeItem = new LineLikeItem();
        likeItem.userId = 1001188;
        likeItem.userNick = "Alan";
        addLikeItem(likeItem, itemId);
    }


    @Override
    protected void onUserClick(int userId) {
        LogHelper.debug("user-click: " + userId);

        Intent intent = new Intent(this, UserFeedActivity.class);
        startActivity(intent);
    }
}