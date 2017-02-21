package com.example.xvjia.camp3.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xvjia.camp3.ui.fragment.FragmentTask_dialy;
import com.example.xvjia.camp3.ui.fragment.FragmentTask_feeder;
import com.example.xvjia.camp3.ui.fragment.FragmentTask_grow;
import com.example.xvjia.camp3.ui.fragment.FragmentTask_main;
import com.example.xvjia.camp3.R;

public class ActivityGameTask extends AppCompatActivity implements View.OnClickListener {

    private ImageView task_back_img;
    private Button task_main_btn, task_feeder_btn, task_grow_btn, task_dialy_btn;

    private FragmentTask_main fragmentTaskMain;
    private FragmentTask_feeder fragmentTaskFeeder;
    private FragmentTask_grow fragmentTaskGrow;
    private FragmentTask_dialy fragmentTaskDialy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_task);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();

    }

    private void initListener() {
        task_back_img.setOnClickListener(this);
        task_main_btn.setOnClickListener(this);
        task_feeder_btn.setOnClickListener(this);
        task_grow_btn.setOnClickListener(this);
        task_dialy_btn.setOnClickListener(this);
    }


    private void initView() {
        task_back_img = (ImageView) findViewById(R.id.task_back);
        task_main_btn = (Button) findViewById(R.id.btn_taskmain);
        task_feeder_btn = (Button) findViewById(R.id.btn_taskfeeder);
        task_grow_btn = (Button) findViewById(R.id.btn_taskgrow);
        task_dialy_btn = (Button) findViewById(R.id.btn_taskdialy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initListener();
        select(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.task_back:
//                Intent intent=new Intent(ActivityGameTask.this,ActivityGameMap1.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.btn_taskmain:
                select(0);
                break;
            case R.id.btn_taskfeeder:
                select(1);
                break;
            case R.id.btn_taskgrow:
                select(2);
                break;
            case R.id.btn_taskdialy:
                select(3);
                break;
        }
    }

    private void select(int i) {
//        FragmentManager fm = getFragmentManager();  //获得Fragment管理器
//        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务
//
//        hidtFragment(ft);   //先隐藏 Fragment

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);

        switch (i) {
            case 0:
                if (fragmentTaskMain == null) {
                    fragmentTaskMain = new FragmentTask_main();
                    ft.add(R.id.task_content, fragmentTaskMain);
                } else {
                    ft.show(fragmentTaskMain);
                }
                task_main_btn.setSelected(true);
                task_feeder_btn.setSelected(false);
                task_grow_btn.setSelected(false);
                task_dialy_btn.setSelected(false);
                break;
            case 1:
                if (fragmentTaskFeeder == null) {
                    fragmentTaskFeeder = new FragmentTask_feeder();
                    ft.add(R.id.task_content, fragmentTaskFeeder);
                } else {
                    ft.show(fragmentTaskFeeder);
                }
                task_main_btn.setSelected(false);
                task_feeder_btn.setSelected(true);
                task_grow_btn.setSelected(false);
                task_dialy_btn.setSelected(false);
                break;
            case 2:
                if (fragmentTaskGrow == null) {
                    fragmentTaskGrow = new FragmentTask_grow();
                    ft.add(R.id.task_content, fragmentTaskGrow);
                } else {
                    ft.show(fragmentTaskGrow);
                }
                task_main_btn.setSelected(false);
                task_feeder_btn.setSelected(false);
                task_grow_btn.setSelected(true);
                task_dialy_btn.setSelected(false);
                break;
            case 3:
                if (fragmentTaskDialy == null) {
                    fragmentTaskDialy = new FragmentTask_dialy();
                    ft.add(R.id.task_content, fragmentTaskDialy);
                } else {
                    ft.show(fragmentTaskDialy);
                }
                task_main_btn.setSelected(false);
                task_feeder_btn.setSelected(false);
                task_grow_btn.setSelected(false);
                task_dialy_btn.setSelected(true);
                break;
        }

        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (fragmentTaskMain != null) {
            ft.hide(fragmentTaskMain);
        }
        if (fragmentTaskFeeder != null) {
            ft.hide(fragmentTaskFeeder);
        }
        if (fragmentTaskGrow != null) {
            ft.hide(fragmentTaskGrow);
        }
        if (fragmentTaskDialy != null) {
            ft.hide(fragmentTaskDialy);
        }
    }
}
