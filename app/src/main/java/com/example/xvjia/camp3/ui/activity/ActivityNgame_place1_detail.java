package com.example.xvjia.camp3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.assetsFile.font.CustomFontTextView2;
import com.example.xvjia.camp3.bean.GameBean;
import com.example.xvjia.camp3.utils.UrlUtils;

public class ActivityNgame_place1_detail extends AppCompatActivity {

    private Button btn_xiangqing;
    private LinearLayout linea_clan1;
    private GameBean gameBean;
    private CustomFontTextView2 tv_title;
    private TextView tv_rank;
    private TextView tv_translate;
    private TextView tv_menber;
    private ImageView iv_place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngame_place1_detail);
        gameBean=getIntent().getParcelableExtra("game");
        initView();
        initLitener();

    }

    private void initView() {
        btn_xiangqing = (Button) findViewById(R.id.btn_xiangqing1);
        linea_clan1 = (LinearLayout) findViewById(R.id.linea_clan1);
        tv_title = (CustomFontTextView2) findViewById(R.id.tv_title);
        tv_rank = (TextView) findViewById(R.id.tv_rank);
        tv_translate = (TextView) findViewById(R.id.tv_translate);
        tv_menber = (TextView) findViewById(R.id.tv_menber);
        iv_place = (ImageView) findViewById(R.id.iv_place);

        tv_title.setText(gameBean.getTitle());
        tv_menber.setText(gameBean.getMenber());
        tv_rank.setText(gameBean.getRank());
        tv_translate.setText(gameBean.getDescription());
        Glide.with(ActivityNgame_place1_detail.this).load(UrlUtils.IMAGEBASE+gameBean.getLogo()).into(iv_place);

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
