package com.example.xvjia.camp3.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.FriendBean;
import com.example.xvjia.camp3.utils.UrlUtils;

public class Activity_friend1_detail extends AppCompatActivity {

    private FriendBean friendBean;
    private ImageView iv_avater;
    private TextView tv_name;
    private TextView tv_address;
    private TextView tv_sex;
    private TextView tv_age;
    private TextView tv_birth;
    private TextView tv_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend1_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        friendBean=getIntent().getParcelableExtra("friend");

        initView();
    }

    private void initView() {
        iv_avater = (ImageView)findViewById(R.id.avater_friend1);
        tv_name = (TextView) findViewById(R.id.name_freind1);
        tv_address = (TextView) findViewById(R.id.edt_act_detail);
        tv_sex = (TextView) findViewById(R.id.edt_act_detai2);
        tv_age = (TextView) findViewById(R.id.edt_act_detai3);
        tv_birth = (TextView) findViewById(R.id.edt_act_detai4);
        tv_description = (TextView) findViewById(R.id.edt_act_detai5);

        Glide.with(Activity_friend1_detail.this).load(UrlUtils.IMAGEBASE+friendBean.getAvater()).into(iv_avater);
        tv_name.setText(friendBean.getName());
        tv_address.setText(friendBean.getAddress());
        tv_sex.setText(friendBean.getSex());
        tv_age.setText(friendBean.getAge());
        tv_birth.setText(friendBean.getBirthday());
        tv_description.setText(friendBean.getDescription());

    }
}
