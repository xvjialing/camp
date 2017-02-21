package com.example.xvjia.camp3.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.xvjia.camp3.R;

public class ActivityGameBag extends AppCompatActivity {

    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_bag);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();

        initListener();
    }

    private void initView() {
        btn_back = (Button) findViewById(R.id.btn_bag_back);
    }

    private void initListener() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ActivityGameBag.this,ActivityGameMap1.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}
