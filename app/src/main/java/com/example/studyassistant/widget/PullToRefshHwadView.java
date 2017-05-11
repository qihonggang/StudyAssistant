package com.example.studyassistant.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.example.studyassistant.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * 下拉刷新
 */
public class PullToRefshHwadView extends FrameLayout implements PtrUIHandler {

    //用来显示刷新动画及图片的ImageVIew
    ImageView img;

    //下拉图片开始id
//   int startId = R.drawable.refresh_001;
    //下拉图片结束id
//    int endId = R.drawable.refresh_048;

    public PullToRefshHwadView(Context context) {
        super(context);
        init();
    }

    private void init() {
        //初始化ImageView
        img = new ImageView(getContext());
        //img拉伸属性
        img.setScaleType(ImageView.ScaleType.FIT_XY);
        //创建ImageView的布局属性
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //居中
        params.gravity = Gravity.CENTER;
        //margin属性
        params.setMargins(50, 50, 50, 50);
        //再把ImageView添加到布局中
        addView(img, params);
        //设置默认图片
//        img.setImageResource(R.drawable.refresh_048);
    }

    public PullToRefshHwadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        //改变图片
         img.setImageResource(R.drawable.setup_clear_cache_img);
        //旋转补间动画
        RotateAnimation anim = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        anim.setDuration(1000);
        //设置匀速，设置线性匀速插值器
        //设置匀速,设置线性匀速插值器
        anim.setInterpolator(new LinearInterpolator());

        //设置重复次数
        anim.setRepeatCount(Animation.INFINITE);
        img.startAnimation(anim);

    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {

        //清掉动画
        img.clearAnimation();
        //设置图片
//        img.setImageResource(R.drawable.refresh_048);


    }

    /**
     *
     *  @param frame
     * @param isUnderTouch      手指是否按下
     * @param status            状态
     * @param ptrIndicator      UI变化指示器
     *
     */
    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {


        //如果当前状态是刷新装填，就不执行当前代码，其他状态就执行
        if(status == PtrFrameLayout.PTR_STATUS_LOADING){
            //如果是刷新状态，不改变图片
            return;
        }

        //根据百分比计算加载图片的索引
        //如果到达百分之百，图片就固定在最后一张
        int per = 0;//图片的索引
//        if(ptrIndicator.getCurrentPercent() <= 1){

//            per = (int) (ptrIndicator.getCurrentPercent() * (endId - startId));
//
//        }else {
//            per = endId - startId;
//        }
//        img.setImageResource(startId + per);
    }
}
