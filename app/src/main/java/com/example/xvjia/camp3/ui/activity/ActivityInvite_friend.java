package com.example.xvjia.camp3.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

public class ActivityInvite_friend extends AppCompatActivity {

    private Button btn_invite_back, btn_invite;
    private MyApplication myApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friend);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initeview();

        initListener();
    }

    private void initeview() {
        btn_invite_back = (Button) findViewById(R.id.btn_invite_back);
        btn_invite = (Button) findViewById(R.id.btn_invite);
    }

    private void initListener() {
        myApplication = (MyApplication) getApplication();
        btn_invite_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(ActivityInvite_friend.this,ActivityGame_team.class);
//                startActivity(intent);
                finish();
            }
        });
        btn_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.setTeam_finger1Tag(1);
                myApplication.setTeam_avater5Tag(1);
                finish();
            }
        });
    }

}
