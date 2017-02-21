package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xvjia.camp3.R;


public class ActivityOrderpage extends AppCompatActivity {

    private Button btn_yuding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderpage);

        initview();

        initlistener();
    }

    private void initview() {
        btn_yuding = (Button) findViewById(R.id.btn_yuding);
    }

    private void initlistener() {
        btn_yuding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "报名成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
                startActivity(intent);
                finish();

            }
        });
    }

}
