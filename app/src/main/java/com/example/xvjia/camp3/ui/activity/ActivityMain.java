package com.example.xvjia.camp3.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.example.xvjia.camp3.bean.LoginBean;
import com.example.xvjia.camp3.bean.UserInfoBean;
import com.example.xvjia.camp3.ui.fragment.FragmentFriend;
import com.example.xvjia.camp3.ui.fragment.FragmentHome;
import com.example.xvjia.camp3.ui.fragment.FragmentMall;
import com.example.xvjia.camp3.ui.fragment.FragmentSetting;
import com.example.xvjia.camp3.ui.fragment.FragmentNgame;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.SharedPreferencesUtils;
import com.example.xvjia.camp3.utils.UrlUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
    private String userid;

    private static final String URL_WATCHINFO= UrlUtils.Url+"watchInfo";
    private static final String TAG=ActivityMain.class.getSimpleName();
    private TextView tv_name;
    private TextView tv_grade;
    private TextView tv_power;
    private TextView tv_gold;
    private TextView tv_exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = this.getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        userid= SharedPreferencesUtils.getParam(ActivityMain.this,"userid","").toString();

        initview();

        initData();

        initListener();

        initAnimation();

        //弹出登录奖励窗口
        DialogDialyLogin();

    }

    private void initData() {
        final AlertDialog dialog=new AlertDialog.Builder(ActivityMain.this)
                .setMessage("正在加载")
                .show();
        RequestUtils requestUtils=new RequestUtils();
        Map<String,String> map=new HashMap<>();
        map.put("id",userid);
        requestUtils.request(map,URL_WATCHINFO)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG,s);
                        UserInfoBean userInfoBean= JSON.parseObject(s,UserInfoBean.class);
                        if (TextUtils.equals("0",String.valueOf(userInfoBean.getLp()))){
                            String name=userInfoBean.getData().get(0).getUsername();
                            String blood=userInfoBean.getData().get(0).getUserBlood();
                            String brain=userInfoBean.getData().get(0).getUserBrains();
                            String exp=userInfoBean.getData().get(0).getUserExp();
                            String grade=userInfoBean.getData().get(0).getUserGrade();
                            String power=userInfoBean.getData().get(0).getUserPower();
                            String gold=userInfoBean.getData().get(0).getUserGold();
                            String userface=userInfoBean.getData().get(0).getUserFace();



                            tv_name.setText(name);
                            tv_grade.setText(grade);
                            tv_power.setText(power);
                            tv_gold.setText(gold);
                            tv_exp.setText(exp);
                            Glide.with(ActivityMain.this).load(UrlUtils.IMAGEBASE+userface).into(img_avater);
                        }
                    }
                });
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
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_grade = (TextView) findViewById(R.id.tv_grade);
        tv_power = (TextView) findViewById(R.id.tv_power);
        tv_gold = (TextView) findViewById(R.id.tv_gold);
        tv_exp = (TextView) findViewById(R.id.tv_exp);
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
