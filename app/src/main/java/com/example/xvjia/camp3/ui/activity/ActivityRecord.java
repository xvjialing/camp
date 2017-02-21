package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityRecord extends AppCompatActivity {

    private ImageView img_record_back;
    private Button btn_share;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        img_record_back = (ImageView) findViewById(R.id.img_record_back);

        btn_share = (Button) findViewById(R.id.btn_share);

        img_record_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRecord.this, ActivityMain.class);
                startActivity(intent);
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myApplication = (MyApplication) getApplication();
                myApplication.setLinea_fenxiangTag(1);
                Intent intent = new Intent(ActivityRecord.this, ActivityClan.class);
                startActivity(intent);
                Toast.makeText(ActivityRecord.this, "分享成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ActivityRecord.this, ActivityMain.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
