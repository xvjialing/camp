package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.example.xvjia.camp3.R;

public class ActivityExplain extends AppCompatActivity {

    private LinearLayout linea_text;
    private TranslateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();

        iniAnimation();
    }

    private void iniAnimation() {

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(2000);
        LinearInterpolator lir = new LinearInterpolator();
        animation.setInterpolator(lir);
        linea_text.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(), ActivityGameMap1.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void initview() {
//        btn_start= (Button) findViewById(R.id.btn_start);
        linea_text = (LinearLayout) findViewById(R.id.linea_explain);
    }

    @Override
    protected void onDestroy() {
        animation = null;
        super.onDestroy();
    }
}
