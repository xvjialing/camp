package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityGame_place1_step2 extends AppCompatActivity {


    private TextView mResultText;
    private Button backBtn;
    private MyApplication myApplication;
    private ImageView texiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_place1_step2);

        mResultText = (TextView) findViewById(R.id.result_text);
        backBtn = (Button) findViewById(R.id.place1_step2_btn);
        texiao = (ImageView) findViewById(R.id.texiao);

        Bundle extras = getIntent().getExtras();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGame_place1_step2.this, ActivityGameMap1.class);
                myApplication = (MyApplication) getApplication();
                myApplication.setNumber(2);
                startActivity(intent);
                finish();
            }
        });

        if (null != extras) {
            String result = extras.getString("result");
            mResultText.setText(result);
        }

//        RotateAnimation animation=new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        animation.setDuration(2000);//设定转一圈的时间
//        animation.setRepeatCount(Animation.INFINITE);//设定无限循环
//        animation.setRepeatMode(Animation.RESTART);
//        LinearInterpolator lir=new LinearInterpolator();
//        animation.setInterpolator(lir);
//        texiao.setAnimation(animation);
    }
}
