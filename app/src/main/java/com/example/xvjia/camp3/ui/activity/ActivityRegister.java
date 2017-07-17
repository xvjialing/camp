package com.example.xvjia.camp3.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.xvjia.camp3.utils.UrlUtils;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.RegisterBean;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.SharedPreferencesUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ActivityRegister extends AppCompatActivity {

    private Button registerBtn;

    private static final String url = UrlUtils.Url + "register";
    private static final String TAG = ActivityRegister.class.getSimpleName();
    private EditText et_username;
    private EditText et_password;
    private EditText et_checkPassword;
    private String str_username;
    private String str_password;
    private String str_checkPassword;
    private EditText et_email;
    private EditText et_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        et_checkPassword = (EditText) findViewById(R.id.et_checkpassword);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);

        registerBtn = (Button) findViewById(R.id.RegisterBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            private String str_phone;
            private String str_email;
            private ProgressDialog progressDialog;

            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(ActivityRegister.this);
                str_username = et_username.getText().toString().trim();
                str_password = et_password.getText().toString().trim();
                str_checkPassword = et_checkPassword.getText().toString().trim();
                str_email = et_email.getText().toString().trim();
                str_phone = et_phone.getText().toString().trim();

                if (!(str_username.isEmpty() && str_password.isEmpty() && str_checkPassword.isEmpty())) {
                    if (TextUtils.equals(str_password, str_checkPassword)) {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("user", str_username);
                        params.put("pwd", str_password);
                        params.put("email", str_email);
                        params.put("phone", str_phone);
                        RequestUtils requestUtils = new RequestUtils();
                        requestUtils.request(params, url).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Subscriber<String>() {
                                    @Override
                                    public void onCompleted() {
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        progressDialog.dismiss();
                                        Toast.makeText(ActivityRegister.this, "请求失败", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onNext(String s) {
                                        Log.d(TAG, s);
                                        RegisterBean registerBean = JSON.parseObject(s, RegisterBean.class);
                                        if (TextUtils.equals(String.valueOf(registerBean.getLp()), "1")) {
                                            Toast.makeText(ActivityRegister.this, registerBean.getData().getMsg(), Toast.LENGTH_SHORT).show();
                                        } else {
                                            String id = String.valueOf(registerBean.getData().getList());
                                            SharedPreferencesUtils.setParam(ActivityRegister.this, "userid", id);

                                            finish();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(ActivityRegister.this, "两次密码不同", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ActivityRegister.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
            }
        }
    };
}
