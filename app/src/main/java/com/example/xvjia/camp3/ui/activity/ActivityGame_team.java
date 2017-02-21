package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityGame_team extends AppCompatActivity implements View.OnClickListener {

    private Button btn_startGame, btn_invite_friend;
    private MyApplication myApplication;
    private Handler handler;
    private Runnable runnable;

    private AlertDialog alertDialog;
    private ImageView img_add_avater;
    private LinearLayout linea_avater5;
    private int fingerTag = 0;

    private TextView tv_TeamMenberState;

    private TextView textView_cuttime;

    //倒计时时间
    private int recLen = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_team);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();
        initListener();

    }


    //    手指动画
    private void initfinger() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.popupwindow_finger, null);
                final PopupWindow popupWindow_finger = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow_finger.setTouchable(true);
                popupWindow_finger.setOutsideTouchable(false);
                popupWindow_finger.setBackgroundDrawable(new BitmapDrawable());
                ImageView img_circle = (ImageView) view.findViewById(R.id.img_finger);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.7f, 1.0f, 0.7f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                LinearInterpolator lir = new LinearInterpolator();
                scaleAnimation.setInterpolator(lir);
                scaleAnimation.setDuration(300);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setRepeatCount(Animation.INFINITE);
                img_circle.setAnimation(scaleAnimation);
                popupWindow_finger.showAsDropDown(findViewById(R.id.btn_invite_freind), 10, -170);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), ActivityInvite_friend.class);
                        startActivity(intent);
                        popupWindow_finger.dismiss();
                    }
                });
            }
        }, 200);
    }

    private void initListener() {
        btn_startGame.setOnClickListener(this);
        btn_invite_friend.setOnClickListener(this);

    }

    private void initview() {
        btn_startGame = (Button) findViewById(R.id.btn_gameStart);
        btn_invite_friend = (Button) findViewById(R.id.btn_invite_freind);
        img_add_avater = (ImageView) findViewById(R.id.img_add_avater);

        linea_avater5 = (LinearLayout) findViewById(R.id.linea5);

        textView_cuttime = (TextView) findViewById(R.id.tv_cut_time);

        tv_TeamMenberState = (TextView) findViewById(R.id.tv_teamMenberState);

    }

    @Override
    public void onClick(View v) {
        myApplication = (MyApplication) getApplication();

        switch (v.getId()) {
            case R.id.btn_gameStart:
                if (myApplication.getTeam_avater5Tag() == 0) {
                    Toast.makeText(ActivityGame_team.this, "人员未到齐", Toast.LENGTH_SHORT).show();
                } else {
                    alertDialog = new AlertDialog.Builder(ActivityGame_team.this).create();
                    alertDialog.show();
                    alertDialog.setCancelable(false);
                    Window window = alertDialog.getWindow();
                    window.setBackgroundDrawable(new BitmapDrawable());
                    window.setContentView(R.layout.loading_process_dialog_anim);
                    handler = new Handler();
                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            alertDialog.dismiss();
                            Intent intent = new Intent(ActivityGame_team.this, ActivityExplain.class);
                            startActivity(intent);
                            finish();
                        }
                    };
                    handler.postDelayed(runnable, 2000);
                }

                break;
            case R.id.btn_invite_freind:
                myApplication = (MyApplication) getApplication();
                if (myApplication.getWaitTag() == 0) {
                    Toast.makeText(ActivityGame_team.this, "请耐心等待", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent1 = new Intent(ActivityGame_team.this, ActivityInvite_friend.class);
                    startActivity(intent1);
                }

                break;
        }
    }

    @Override
    protected void onStart() {
        myApplication = (MyApplication) getApplication();

        if (myApplication.getTeam_avater5Tag() == 0) {
            img_add_avater.setVisibility(View.VISIBLE);
            linea_avater5.setVisibility(View.INVISIBLE);

            handler1.postDelayed(runnable1, 1000);

        } else {
            linea_avater5.setVisibility(View.VISIBLE);
            img_add_avater.setVisibility(View.INVISIBLE);

            tv_TeamMenberState.setText(R.string.teamNumberCompelete);
        }

        super.onStart();
    }

    @Override
    protected void onStop() {
//        mTime=null;
        super.onStop();
    }

    Handler handler1 = new Handler();
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            if (recLen > 0) {
                recLen--;
                textView_cuttime.setText("0" + recLen);
                handler1.postDelayed(this, 1000);
            } else {
                myApplication = (MyApplication) getApplication();
                myApplication.setWaitTag(1);
                initfinger();

            }
        }
    };
}
