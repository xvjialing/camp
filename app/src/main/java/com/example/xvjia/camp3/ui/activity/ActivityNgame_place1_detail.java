package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.xvjia.camp3.R;

public class ActivityNgame_place1_detail extends AppCompatActivity {

    private Button btn_xiangqing;
    private LinearLayout linea_clan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngame_place1_detail);

        initView();
        initLitener();

    }

    private void initView() {
        btn_xiangqing = (Button) findViewById(R.id.btn_xiangqing1);
        linea_clan1 = (LinearLayout) findViewById(R.id.linea_clan1);

    }

    private void initLitener() {

        btn_xiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityNgame_place1_detail.this, ActivityOrderpage.class);
                startActivity(intent);
                finish();
            }
        });
        linea_clan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNgame_place1_detail.this, ActivityClan.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
