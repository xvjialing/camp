package com.example.xvjia.camp3.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.GoodsBean;
import com.example.xvjia.camp3.utils.UrlUtils;

public class ActivityGoodsDetail extends AppCompatActivity {

    private GoodsBean goodsBean;
    private ImageView iv_goods;
    private TextView tv_goodsname;
    private TextView tv_price;
    private TextView tv_decription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        goodsBean=getIntent().getParcelableExtra("good");

        intView();

        initData();
    }

    private void initData() {
        Glide.with(ActivityGoodsDetail.this).load(UrlUtils.IMAGEBASE+goodsBean.getPic()).into(iv_goods);
        tv_goodsname.setText(goodsBean.getName());
        tv_price.setText(goodsBean.getPrice());
        tv_decription.setText(goodsBean.getDescription());
    }

    private void intView() {
        iv_goods = (ImageView) findViewById(R.id.iv_goods);
        tv_goodsname = (TextView) findViewById(R.id.tv_goodsname);
        tv_price = (TextView) findViewById(R.id.tv_price);
        tv_decription = (TextView) findViewById(R.id.tv_description);
    }
}
