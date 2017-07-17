package com.example.xvjia.camp3.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.xvjia.camp3.utils.UrlUtils;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.LoginBean;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.SharedPreferencesUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ActivityLogin extends Activity {

    private Button btnLogin, btnRegister;
    private EditText username;
    private EditText pwd;

    private String name;
    private String password;

    private static final String url_login = UrlUtils.Url + "login";

    private static final String TAG = ActivityLogin.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();

        initlistener();
    }

    private void initlistener() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog=new ProgressDialog(ActivityLogin.this);
                progressDialog.setMessage("正在登陆……");
                progressDialog.show();
                name = username.getText().toString().trim();
                password = pwd.getText().toString().trim();
                if (TextUtils.equals(name, "") || TextUtils.equals(password, "")) {
                    Toast.makeText(ActivityLogin.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("user", name);
                    map.put("pwd", password);
                    RequestUtils requestUtils = new RequestUtils();
                    requestUtils.request(map, url_login).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<String>() {
                                @Override
                                public void onCompleted() {
                                    progressDialog.dismiss();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    progressDialog.dismiss();
                                    Toast.makeText(ActivityLogin.this, "请求出错" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onNext(String s) {
                                    Logger.json(s);

                                    LoginBean loginBean = JSON.parseObject(s, LoginBean.class);
                                    if (TextUtils.equals(String.valueOf(loginBean.getLp()), "1")) {
                                        Toast.makeText(ActivityLogin.this, loginBean.getData().getMsg().toString(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        String id = loginBean.getData().getInfo().getId();
                                        String username = loginBean.getData().getInfo().getUsername();
                                        String phone = loginBean.getData().getInfo().getPhone();
                                        String email = loginBean.getData().getInfo().getEmail();
                                        Logger.d(id);
                                        SharedPreferencesUtils.setParam(ActivityLogin.this, "userid", id);
                                        SharedPreferencesUtils.setParam(ActivityLogin.this, "username", username);
                                        SharedPreferencesUtils.setParam(ActivityLogin.this, "phone", phone);
                                        SharedPreferencesUtils.setParam(ActivityLogin.this, "email", email);
                                        startActivity(new Intent(ActivityLogin.this, ActivityMain.class));
                                        finish();
                                    }
                                }
                            });
                }


            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });
    }

    private void initview() {
        btnLogin = (Button) findViewById(R.id.loginbtn);
        btnRegister = (Button) findViewById(R.id.registerBtn);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.pwd);
    }


}