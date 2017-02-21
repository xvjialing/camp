package com.example.xvjia.camp3.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xvjia.camp3.R;

public class ActivityAdd_camp extends AppCompatActivity {

    private Button btn_queding, btn_cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camp);

        initView();

        initListener();
    }

    private void initView() {
        btn_queding = (Button) findViewById(R.id.btn_add_queding);
        btn_cancle = (Button) findViewById(R.id.btn_add_cancle);
    }

    private void initListener() {
        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "申请成功，请等待审核结果！", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
