package com.example.xvjia.camp3.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xvjia.camp3.ui.fragment.FragmentFriend;
import com.example.xvjia.camp3.ui.fragment.FragmentHome;
import com.example.xvjia.camp3.ui.fragment.FragmentMall;
import com.example.xvjia.camp3.ui.fragment.FragmentSetting;
import com.example.xvjia.camp3.ui.fragment.FragmentNgame;
import com.example.xvjia.camp3.R;

public class ActivityMain extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private FragmentHome fragmentHome;
    private FragmentNgame fragmentNgame;
    private FragmentFriend fragmentFriend;
    private FragmentMall fragmentMall;
    private FragmentSetting fragmentSetting;

    private AlertDialog alertDialog_dialy_login;


    private Button btnHome, btnNgame, btnFriend, btnMall, btnSetting;

    private ImageView img_avater;

    private long mExitTime = 0;
    private LinearLayout linea_toptv;

    //主页菜单标记
    private String mainFragTag = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = this.getSupportFragmentManager();
        setContentView(R.layout.activity_main);

        initview();

        initListener();

        initAnimation();

        //弹出登录奖励窗口
        DialogDialyLogin();

    }

    private void initAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        LinearInterpolator lir = new LinearInterpolator();
        translateAnimation.setInterpolator(lir);
        translateAnimation.setDuration(5000);
        translateAnimation.setRepeatMode(Animation.RESTART);
        translateAnimation.setRepeatCount(Animation.INFINITE);
        linea_toptv.setAnimation(translateAnimation);
    }

    private void initListener() {
        btnHome.setOnClickListener(this);
        btnNgame.setOnClickListener(this);
        btnFriend.setOnClickListener(this);
        btnMall.setOnClickListener(this);
        btnSetting.setOnClickListener(this);

        img_avater.setOnClickListener(this);
    }

    private void initview() {
        btnHome = (Button) findViewById(R.id.homeBtn);
        btnNgame = (Button) findViewById(R.id.ngameBtn);
        btnFriend = (Button) findViewById(R.id.friendBtn);
        btnMall = (Button) findViewById(R.id.mallBtn);
        btnSetting = (Button) findViewById(R.id.settingBtn);

        img_avater = (ImageView) findViewById(R.id.img_top_avater);

        linea_toptv = (LinearLayout) findViewById(R.id.linea_main_toptv);

    }

    @Override
    public void onClick(View v) {
        ft = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.homeBtn:
                clickHome();
                break;
            case R.id.ngameBtn:
                clickNgame();
                break;
            case R.id.friendBtn:
                clickFriend();
                break;
            case R.id.mallBtn:
                clickMall();
                break;
            case R.id.settingBtn:
                clickSetting();
                break;
        }
        ft.commit();
    }

    //弹出每日登录奖励窗口
    private void DialogDialyLogin() {
        alertDialog_dialy_login = new AlertDialog.Builder(this).create();
        alertDialog_dialy_login.show();
        alertDialog_dialy_login.setCancelable(false);
        Window window = alertDialog_dialy_login.getWindow();
        window.setBackgroundDrawableResource(R.color.vifrification);
        window.setWindowAnimations(R.style.dialogWindowAnim);
        window.setContentView(R.layout.dialog_dialy_login);
        Button btn_get = (Button) window.findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog_dialy_login.dismiss();
            }
        });
    }


    private void clickHome() {
        fragmentHome = new FragmentHome();
        ft.replace(R.id.fragmentContent, fragmentHome);

        mainFragTag = "0";
    }

    private void clickNgame() {
        fragmentNgame = new FragmentNgame();
        ft.replace(R.id.fragmentContent, fragmentNgame);

        mainFragTag = "1";
    }

    private void clickFriend() {
        fragmentFriend = new FragmentFriend();
        ft.replace(R.id.fragmentContent, fragmentFriend);

        mainFragTag = "2";
    }

    private void clickMall() {
        fragmentMall = new FragmentMall();
        ft.replace(R.id.fragmentContent, fragmentMall);

        mainFragTag = "3";
    }

    private void clickSetting() {
        fragmentSetting = new FragmentSetting();
        ft.replace(R.id.fragmentContent, fragmentSetting);

        mainFragTag = "4";
    }

    @Override
    protected void onStart() {
        super.onStart();
        ft = fragmentManager.beginTransaction();
        switch (mainFragTag) {
            case "0":
                clickHome();
                break;
            case "1":
                clickNgame();
                break;
            case "2":
                clickFriend();
                break;
            case "3":
                clickMall();
                break;
            case "4":
                clickSetting();
                break;
        }
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    //快速双击退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
