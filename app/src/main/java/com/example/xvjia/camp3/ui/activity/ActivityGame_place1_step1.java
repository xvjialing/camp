package com.example.xvjia.camp3.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.maps2d.MapView;
import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityGame_place1_step1 extends Activity {

    private Button qrcodeBtn;
    private PopupWindow popupWindow_message_left;
    private ImageView img_back, img_shop, img_task, img_bag;
    private MyApplication myApplication;
    private ImageView img_help;
    private AlertDialog alertDialog;
    private ImageView img_avater;
    private static final int REQUEST_PERMISSION_CAMERA_CODE = 1;

    private CountDownTimer countDownTimer;

    private TextView textView_cutTime;
    //弹窗1标签
    private int a = 1;
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_place1_step1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();
        mapView.onCreate(savedInstanceState);

        initListener();

        initAnim();

        initCutTime();
        countDownTimer.start();
    }

    private void initAnim() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lir = new LinearInterpolator();
        scaleAnimation.setInterpolator(lir);
        scaleAnimation.setDuration(300);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        img_help.setAnimation(scaleAnimation);


        TranslateAnimation alphaAnimation = new TranslateAnimation(-10f, -10f, -15, -5);
        alphaAnimation.setDuration(300);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        img_avater.setAnimation(alphaAnimation);
    }

    @Override
    protected void onStart() {

        Handler handler3 = new Handler();
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                initPopupWindow1();
            }
        };
        handler3.postDelayed(runnable3, 100);

        super.onStart();
    }

    private void initPopupwindow() {
        myApplication = (MyApplication) getApplication();
        View view = LayoutInflater.from(ActivityGame_place1_step1.this).inflate(R.layout.popupwindow_message_left, null);
        popupWindow_message_left = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow_message_left.setTouchable(true);
        popupWindow_message_left.setOutsideTouchable(false);
        popupWindow_message_left.setAnimationStyle(R.style.dialogWindowAnim);
        popupWindow_message_left.setBackgroundDrawable(new BitmapDrawable());
        popupWindow_message_left.showAtLocation(findViewById(R.id.rela_game_step1), Gravity.START | Gravity.BOTTOM, 50, 50);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_avater);
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.avater_zhangfei));

        final TextView textView = (TextView) view.findViewById(R.id.tv_pop);
        textView.setText("遇突发状况，遭遇暴风雪，时间已不足！");

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (a) {
                    case 1:
                        textView.setText("请到向好友求救或商店购买时间药水。");
                        myApplication.setPlace1_step1_dialog1Tag(1);
                        break;
                    case 2:
                        popupWindow_message_left.dismiss();
                        break;
                }
                a++;

            }
        });
    }

    private void initPopupWindow1() {
        View view = LayoutInflater.from(ActivityGame_place1_step1.this).inflate(R.layout.popupwindow_message_left, null);
        popupWindow_message_left = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow_message_left.setTouchable(true);
        popupWindow_message_left.setOutsideTouchable(false);
        popupWindow_message_left.setAnimationStyle(R.style.dialogWindowAnim);
        popupWindow_message_left.setBackgroundDrawable(new BitmapDrawable());
        popupWindow_message_left.showAtLocation(findViewById(R.id.rela_game_step1), Gravity.START | Gravity.BOTTOM, 50, 50);

        ImageView imageView = (ImageView) view.findViewById(R.id.img_avater);
        imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.avater_zhangfei));

        TextView textView = (TextView) view.findViewById(R.id.tv_pop);
        textView.setText("请您在1小时内，在指定场地内，根据线索到达目的地，获得锦囊后扫描上方二维码获得下一关提示");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_message_left.dismiss();
            }
        });
    }

    private void initview() {
        qrcodeBtn = (Button) findViewById(R.id.place1_step1_Btn);

        img_back = (ImageView) findViewById(R.id.game_back);
        img_bag = (ImageView) findViewById(R.id.GameBagImg);
        img_shop = (ImageView) findViewById(R.id.GameShopImg);
        img_task = (ImageView) findViewById(R.id.GameTaskImg);

        img_help = (ImageView) findViewById(R.id.img_help);

        textView_cutTime = (TextView) findViewById(R.id.tv_cutTime2);

        img_avater = (ImageView) findViewById(R.id.smallmapAvater);

        mapView = (MapView) findViewById(R.id.mapView);


    }

    private void initListener() {
        qrcodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(ActivityGame_place1_step1.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(ActivityGame_place1_step1.this,
                            Manifest.permission.CAMERA)) {

                    } else {
                        ActivityCompat.requestPermissions(ActivityGame_place1_step1.this,
                                new String[]{Manifest.permission.CAMERA},
                                REQUEST_PERMISSION_CAMERA_CODE);
                    }
                } else {
                    Intent intent = new Intent(ActivityGame_place1_step1.this, ActivityCapture.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ActivityGame_place1_step1.this,ActivityGameMap1.class);
//                startActivity(intent);
                finish();
            }
        });

        img_bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGame_place1_step1.this, ActivityGameBag.class);
                startActivity(intent);
            }
        });

        img_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGame_place1_step1.this, ActivityGameShop.class);
                startActivity(intent);
            }
        });

        img_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog = new AlertDialog.Builder(ActivityGame_place1_step1.this).create();
                alertDialog.show();
                alertDialog.setCancelable(true);
                Window window = alertDialog.getWindow();
                window.setBackgroundDrawable(new BitmapDrawable());
                window.setContentView(R.layout.dialog_help);
                window.setWindowAnimations(R.style.dialogWindowAnim);
                Button btn_dialog_help = (Button) window.findViewById(R.id.btn_dialog_help);
                btn_dialog_help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        Toast.makeText(ActivityGame_place1_step1.this, "求救成功,等待队员支援", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CAMERA_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(ActivityGame_place1_step1.this, ActivityCapture.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(ActivityGame_place1_step1.this, "没有相机权限", Toast.LENGTH_SHORT).show();
                }
                return;
            }

        }
    }


    private void initCutTime() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if ((millisUntilFinished / 1000) >= 10) {
                    textView_cutTime.setText("00:" + (millisUntilFinished / 1000));
                } else {
                    textView_cutTime.setText("00:0" + (millisUntilFinished / 1000));
                }

            }

            @Override
            public void onFinish() {
                textView_cutTime.setText("00:00");
                initPopupwindow();
            }
        };
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        mapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
