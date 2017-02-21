package com.example.xvjia.camp3.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
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

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

import java.lang.ref.WeakReference;

public class ActivityGameMap1 extends AppCompatActivity {

    private ImageView game_tag1, game_tag2, game_tag3, game_tag4, game_tag5;
    private ImageView game_avater1, game_avater2, game_avater3, game_avater4, game_avater5, game_avater6;
    private ImageView img_shout;
    private ImageView gameback, gameBag, gameTask, gameShop;

    private PopupWindow popupWindow_message_left, popupWindow_message_right;

    //dialog中的控件
    private Button btn_place1_enter, btn_place1_back, btn_dialog_place2_enter, btn_dialog_place2_back;

    private AlertDialog alertDialog;

    private MyApplication myApplication;

    private Handler handler;
    private Runnable runnable;
    private int n = 1;

    //人物对话标记
    private int a = 0;
    private int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_map1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();
    }

    //初始化动画
    private void initAnimation(int n) {
        TranslateAnimation alphaAnimation = new TranslateAnimation(-10f, -10f, -15, -5);
        alphaAnimation.setDuration(300);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        switch (n) {
            case 1:
                game_avater1.setVisibility(View.VISIBLE);
                game_avater1.setAnimation(alphaAnimation);
                break;
            case 2:
                game_avater2.setVisibility(View.VISIBLE);
                game_avater2.setAnimation(alphaAnimation);

                game_avater1.setVisibility(View.INVISIBLE);
                game_avater1.clearAnimation();
                break;
            case 3:
                game_avater3.setVisibility(View.VISIBLE);
                game_avater3.setAnimation(alphaAnimation);

                game_avater2.setVisibility(View.INVISIBLE);
                game_avater2.clearAnimation();
                break;
            case 4:
                game_avater4.setVisibility(View.VISIBLE);
                game_avater4.setAnimation(alphaAnimation);

                game_avater3.setVisibility(View.INVISIBLE);
                game_avater3.clearAnimation();
                break;
            case 5:
                game_avater5.setVisibility(View.VISIBLE);
                game_avater5.setAnimation(alphaAnimation);

                game_avater4.setVisibility(View.INVISIBLE);
                game_avater4.clearAnimation();
                break;
            case 6:
                game_avater6.setVisibility(View.VISIBLE);
                game_avater6.setAnimation(alphaAnimation);

                game_avater5.setVisibility(View.INVISIBLE);
                game_avater5.clearAnimation();
                break;
        }
        alphaAnimation.start();

        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lir = new LinearInterpolator();
        scaleAnimation.setInterpolator(lir);
        scaleAnimation.setDuration(300);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        img_shout.setAnimation(scaleAnimation);
    }

    //初始化监听器
    private void initListener() {

        myApplication = (MyApplication) getApplication();
        n = myApplication.getNumber();

        game_tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n > 1) {
                    Toast.makeText(getApplicationContext(), "已完成此关卡！", Toast.LENGTH_SHORT).show();
                } else {
                    alertDialog = new AlertDialog.Builder(ActivityGameMap1.this).create();
                    alertDialog.show();
                    Window window = alertDialog.getWindow();
                    window.setContentView(R.layout.dialog_map1_place1);
                    window.setBackgroundDrawable(new BitmapDrawable());
                    alertDialog.setCancelable(true);
                    window.setWindowAnimations(R.style.dialogWindowAnim);
                    initview_place1_dilog(window);

                    initListener_place1_dilog(alertDialog);

                }
            }
        });

        game_tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n < 2) {
                    Toast.makeText(getApplicationContext(), "还没到此关卡！", Toast.LENGTH_SHORT).show();
                } else if (n > 2) {
                    Toast.makeText(getApplicationContext(), "已完成此关卡！", Toast.LENGTH_SHORT).show();
                } else {
//                    AlertDialog alertDialog=new AlertDialog.Builder(ActivityGameMap1.this).create();
//                    alertDialog.show();
//                    alertDialog.setCancelable(true);
//                    Window window=alertDialog.getWindow();
//                    window.setContentView(R.layout.dialog_map1_place2);
//                    window.setBackgroundDrawable(new BitmapDrawable());
//                    initview_place2_dilog(window);
//
//                    initListener_place2_dialog(alertDialog);
//
////                    Intent intent=new Intent(ActivityGameMap1.this,ActivityGame_place2_step1.class);
////                    n=3;
////                    startActivity(intent);
                    TranslateAnimation alphaAnimation = new TranslateAnimation(-10f, -10f, -15, -5);
                    alphaAnimation.setDuration(300);
                    alphaAnimation.setRepeatCount(Animation.INFINITE);
                    alphaAnimation.setRepeatMode(Animation.REVERSE);
                    game_avater5.setVisibility(View.VISIBLE);
                    game_avater5.setAnimation(alphaAnimation);

                    game_avater2.setVisibility(View.INVISIBLE);
                    game_avater2.clearAnimation();
                    alphaAnimation.start();
                    n = 5;
                }
            }
        });
        game_tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n < 3) {
                    Toast.makeText(getApplicationContext(), "还没到此关卡！", Toast.LENGTH_SHORT).show();
                } else if (n > 3) {
                    Toast.makeText(getApplicationContext(), "已完成此关卡！", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ActivityGameMap1.this, ActivityGame_place3_step1.class);
                    n = 4;
                    startActivity(intent);
                }
            }
        });
        game_tag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n < 4) {
                    Toast.makeText(getApplicationContext(), "还没到此关卡！", Toast.LENGTH_SHORT).show();
                } else if (n > 4) {
                    Toast.makeText(getApplicationContext(), "已完成此关卡！", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ActivityGameMap1.this, ActivityGame_place4_step1.class);
                    n = 5;
                    startActivity(intent);
                }
            }
        });
        game_tag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n < 5) {
                    Toast.makeText(getApplicationContext(), "还没到此关卡！", Toast.LENGTH_SHORT).show();
                } else if (n > 5) {
                    Toast.makeText(getApplicationContext(), "已完成此关卡！", Toast.LENGTH_SHORT).show();
                } else {
//                    Intent intent=new Intent(ActivityGameMap1.this,ActivityGame_place5_step1.class);
//                    n=6;
//                    startActivity(intent);
                    final AlertDialog dialog = new AlertDialog.Builder(ActivityGameMap1.this).create();
                    dialog.show();
                    dialog.setCancelable(true);
                    Window window = dialog.getWindow();
                    window.setWindowAnimations(R.style.dialogWindowAnim);
                    window.setContentView(R.layout.dialog_gameover);
                    window.setBackgroundDrawable(new BitmapDrawable());

                    Button btn_gotoRecord = (Button) window.findViewById(R.id.btn_gotoRecord);
                    btn_gotoRecord.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent = new Intent(ActivityGameMap1.this, ActivityRecord.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });

        gameback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMap1.this, ActivityMain.class);
                startActivity(intent);

                finish();
            }
        });

        gameBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMap1.this, ActivityGameBag.class);
                startActivity(intent);
            }
        });

        //跳转到游戏任务界面
        gameTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMap1.this, ActivityGameTask.class);
                startActivity(intent);

            }
        });

        gameShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMap1.this, ActivityGameShop.class);
                startActivity(intent);
            }
        });


    }

    private void initListener_place2_dialog(final AlertDialog alertDialog) {
        btn_dialog_place2_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMap1.this, ActivityGame_place2_step1.class);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });
        btn_dialog_place2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void initview_place2_dilog(Window window) {
        btn_dialog_place2_enter = (Button) window.findViewById(R.id.btn_map1_place2_enter);
        btn_dialog_place2_back = (Button) window.findViewById(R.id.btn_place2_back);
    }

    //初始化地点1的监听器
    private void initListener_place1_dilog(final AlertDialog alertDialog) {
        btn_place1_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityGameMap1.this, ActivityGame_place1_step1.class);
                startActivity(intent);
                alertDialog.dismiss();
            }
        });

        btn_place1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    //初始化地点1对话框的控件
    private void initview_place1_dilog(Window window) {
        btn_place1_enter = (Button) window.findViewById(R.id.btn_map1_place1_enter);
        btn_place1_back = (Button) window.findViewById(R.id.btn_place1_back);
    }

    //初始化控件
    private void initview() {
        game_tag1 = (ImageView) findViewById(R.id.maptag1);
        game_tag2 = (ImageView) findViewById(R.id.maptag2);
        game_tag3 = (ImageView) findViewById(R.id.maptag3);
        game_tag4 = (ImageView) findViewById(R.id.maptag4);
        game_tag5 = (ImageView) findViewById(R.id.maptag5);
        game_avater1 = (ImageView) findViewById(R.id.map_avater1);
        game_avater2 = (ImageView) findViewById(R.id.map_avater2);
        game_avater3 = (ImageView) findViewById(R.id.map_avater3);
        game_avater4 = (ImageView) findViewById(R.id.map_avater4);
        game_avater5 = (ImageView) findViewById(R.id.map_avater5);
        game_avater6 = (ImageView) findViewById(R.id.map_avater6);

        gameback = (ImageView) findViewById(R.id.game_back);
        gameBag = (ImageView) findViewById(R.id.GameBagImg);
        gameTask = (ImageView) findViewById(R.id.GameTaskImg);
        gameShop = (ImageView) findViewById(R.id.GameShopImg);

        img_shout = (ImageView) findViewById(R.id.img_shout);
    }


    @Override
    protected void onStart() {
        super.onStart();

        myApplication = (MyApplication) getApplication();
        n = myApplication.getNumber();

        //初始化控件
        initListener();

        //初始化动画
        initAnimation(n);

        initSuccessDialog();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                initPopupwindow(n);
            }
        };
        handler.postDelayed(runnable, 100);

    }

    //成功弹窗
    private void initSuccessDialog() {
        myApplication = (MyApplication) getApplication();
        switch (myApplication.getMapSucessdialog1Tag()) {
            case 1:
                AlertDialog dialog = new AlertDialog.Builder(ActivityGameMap1.this).create();
                dialog.show();
                dialog.setCancelable(true);
                Window window = dialog.getWindow();
                window.setWindowAnimations(R.style.dialogWindowAnim);
                window.setContentView(R.layout.dialog_success);
                window.setBackgroundDrawable(new BitmapDrawable());

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        place2();
                    }
                });
                break;
        }
    }

    //初始化popupwindow,并使背景半透明
    private void initPopupwindow(int n) {
        switch (n) {
            case 1:
                place1();
                break;
            case 2:

                break;
        }
    }

    //关卡2介绍
    private void place2() {
        if (b == 0) {
            View view = LayoutInflater.from(ActivityGameMap1.this).inflate(R.layout.popupwindow_message_left, null);
            popupWindow_message_left = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow_message_left.setTouchable(true);
            popupWindow_message_left.setOutsideTouchable(false);
            popupWindow_message_left.setBackgroundDrawable(new BitmapDrawable());
            popupWindow_message_left.setAnimationStyle(R.style.dialogWindowAnim);
            popupWindow_message_left.showAtLocation(findViewById(R.id.maprela), Gravity.START | Gravity.BOTTOM, 50, 50);

            ImageView imageView = (ImageView) view.findViewById(R.id.img_avater);
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.avater_zhugeliang));

            TextView textView = (TextView) view.findViewById(R.id.tv_pop);
            textView.setText("恭喜您通过第一关");
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow_message_left.dismiss();
                }
            });
        }
    }

    //关卡1的游戏介绍
    private void place1() {
        if (a == 0) {
            View view = LayoutInflater.from(ActivityGameMap1.this).inflate(R.layout.popupwindow_message_left, null);
            popupWindow_message_left = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow_message_left.setTouchable(true);
            popupWindow_message_left.setOutsideTouchable(false);
            popupWindow_message_left.setAnimationStyle(R.style.dialogWindowAnim);
            popupWindow_message_left.setBackgroundDrawable(new BitmapDrawable());
            popupWindow_message_left.showAtLocation(findViewById(R.id.maprela), Gravity.START | Gravity.BOTTOM, 50, 50);

            ImageView imageView = (ImageView) view.findViewById(R.id.img_avater);
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.avater_zhugeliang));

            TextView textView = (TextView) view.findViewById(R.id.tv_pop);
            textView.setText(R.string.explainString1);
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.alpha = 0.5f;
            getWindow().setAttributes(params);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    closePopupwindow(popupWindow_message_left);

                    View view1 = LayoutInflater.from(ActivityGameMap1.this).inflate(R.layout.popupwindow_message_right, null);
                    popupWindow_message_right = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow_message_right.setTouchable(true);
                    popupWindow_message_right.setAnimationStyle(R.style.dialogWindowAnim);
                    popupWindow_message_right.setOutsideTouchable(false);
                    popupWindow_message_right.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow_message_right.showAtLocation(findViewById(R.id.maprela), Gravity.END | Gravity.BOTTOM, 50, 50);
                    ImageView imageView1 = (ImageView) view1.findViewById(R.id.img_avater);
                    imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.avater_zhangfei));

                    TextView textView1 = (TextView) view1.findViewById(R.id.tv_pop);
                    textView1.setText(R.string.explainString2);
                    WindowManager.LayoutParams params = getWindow().getAttributes();
                    params.alpha = 0.5f;
                    getWindow().setAttributes(params);
                    textView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            closePopupwindow(popupWindow_message_right);
                        }
                    });

                }
            });

            a++;
        }

    }

    //关闭popupwindow，并去除背景半透明
    private void closePopupwindow(PopupWindow popupWindow) {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            popupWindow = null;
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.alpha = 1f;
            getWindow().setAttributes(params);
        }
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        handler.removeCallbacks(runnable);
        alertDialog = null;
        handler = null;
        //myApplication=null;
        super.onDestroy();
    }
}
