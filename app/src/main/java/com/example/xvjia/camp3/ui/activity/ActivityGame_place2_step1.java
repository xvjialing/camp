package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.xvjia.camp3.R;

public class ActivityGame_place2_step1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBag, imgShop, imgTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_place2_step1);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();

        initListener();
    }

    private void initListener() {
        imgBag.setOnClickListener(this);
        imgShop.setOnClickListener(this);
        imgTask.setOnClickListener(this);
    }

    private void initView() {
        imgBag = (ImageView) findViewById(R.id.GameBagImg);
        imgShop = (ImageView) findViewById(R.id.GameShopImg);
        imgTask = (ImageView) findViewById(R.id.GameTaskImg);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.GameBagImg:
                intent = new Intent(ActivityGame_place2_step1.this, ActivityGameBag.class);
                startActivity(intent);
                break;
            case R.id.GameShopImg:
                intent = new Intent(ActivityGame_place2_step1.this, ActivityGameShop.class);
                startActivity(intent);
                break;
            case R.id.GameTaskImg:
                intent = new Intent(ActivityGame_place2_step1.this, ActivityGameTask.class);
                startActivity(intent);
                break;
        }

    }
}
