package com.example.xvjia.camp3.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.xvjia.camp3.R;

public class ActivityStartPage extends Activity {

    private ImageView mImg;
    private Animation anim;
    private Drawable mDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mImg = (ImageView) findViewById(R.id.startPic);

        init();

        initListener();
    }

    private void initListener() {
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(ActivityStartPage.this, ActivityLogin.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initAnim() {
        anim = AnimationUtils.loadAnimation(this, R.anim.guide_welcome_fade);

    }

    private void initPic() {
        mDraw = getResources().getDrawable(R.drawable.startpic);
    }

    private void init() {
        initPic();
        initAnim();

        mImg.setImageDrawable(mDraw);
        mImg.setAnimation(anim);
    }
}
