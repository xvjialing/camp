package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityClan extends AppCompatActivity {

    private Button btn_invite, btn_join_in;

    private ImageView img_back;

    private LinearLayout linea_fenxiang;

    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clan);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();

        initListener();
    }

    private void initview() {
        btn_invite = (Button) findViewById(R.id.btn_clan_invite);
        btn_join_in = (Button) findViewById(R.id.btn_jion_in);
        img_back = (ImageView) findViewById(R.id.img_clan_back);
        linea_fenxiang = (LinearLayout) findViewById(R.id.linea_fenxiang);
    }

    private void initListener() {
        btn_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityClan.this, ActivityNgame_place1_detail.class);
                startActivity(intent);
                finish();
            }
        });
        btn_join_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication = (MyApplication) getApplication();
                myApplication.setClanTag(1);
                btn_join_in.setText("退出");
                Toast.makeText(ActivityClan.this, "加入成功", Toast.LENGTH_SHORT).show();
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityClan.this, ActivityMain.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(ActivityClan.this, ActivityMain.class);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onStart() {

        myApplication = (MyApplication) getApplication();
        if (myApplication.getLinea_fenxiangTag() == 0) {
            linea_fenxiang.setVisibility(View.INVISIBLE);
        } else {
            linea_fenxiang.setVisibility(View.VISIBLE);
        }

        if (myApplication.getClanTag() == 0) {
            btn_join_in.setText("加入");
        } else {
            btn_join_in.setText("退出");
        }
        super.onStart();
    }
}
