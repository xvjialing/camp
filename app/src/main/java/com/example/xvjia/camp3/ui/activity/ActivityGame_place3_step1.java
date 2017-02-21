package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.xvjia.camp3.R;

public class ActivityGame_place3_step1 extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_shop, img_bag, img_task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_place3_step1);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        initview();

        initLitener();
    }

    private void initLitener() {
        img_bag.setOnClickListener(this);
        img_task.setOnClickListener(this);
        img_shop.setOnClickListener(this);
    }

    private void initview() {
        img_bag = (ImageView) findViewById(R.id.GameBagImg);
        img_shop = (ImageView) findViewById(R.id.GameShopImg);
        img_task = (ImageView) findViewById(R.id.GameTaskImg);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.GameBagImg:
                intent = new Intent(getApplicationContext(), ActivityGameBag.class);
                startActivity(intent);
                break;
            case R.id.GameShopImg:
                intent = new Intent(getApplicationContext(), ActivityGameShop.class);
                startActivity(intent);
                break;
            case R.id.GameTaskImg:
                intent = new Intent(getApplicationContext(), ActivityGameTask.class);
                startActivity(intent);
                break;
        }
    }
}
