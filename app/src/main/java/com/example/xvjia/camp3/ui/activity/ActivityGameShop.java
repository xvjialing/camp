package com.example.xvjia.camp3.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.ui.fragment.FragmentGame_shop_buy;
import com.example.xvjia.camp3.ui.fragment.FragmentGame_shop_sale;

public class ActivityGameShop extends AppCompatActivity implements View.OnClickListener {

    private ImageView shopback;

    private FragmentGame_shop_buy fragmentGameShopBuy;
    private FragmentGame_shop_sale fragmentGameShopSale;

    private Button btn_buy, btn_sale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_shop);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initview();

        initListener();
        select(0);
    }

    private void initview() {
        shopback = (ImageView) findViewById(R.id.shop_back);
        btn_buy = (Button) findViewById(R.id.btn_gameshop_buy);
        btn_sale = (Button) findViewById(R.id.btn_gameshop_sale);
    }

    private void initListener() {
        shopback.setOnClickListener(this);
        btn_buy.setOnClickListener(this);
        btn_sale.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop_back:
//                Intent intent=new Intent(ActivityGameShop.this,ActivityGameMap1.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.btn_gameshop_buy:
                select(0);
                break;
            case R.id.btn_gameshop_sale:
                select(1);
                break;
        }
    }

    private void select(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        hideFragment(ft);

        switch (i) {
            case 0:
                if (fragmentGameShopBuy == null) {
                    fragmentGameShopBuy = new FragmentGame_shop_buy();
                    ft.add(R.id.shop_content, fragmentGameShopBuy);
                } else {
                    ft.show(fragmentGameShopBuy);
                }
                btn_buy.setSelected(true);
                btn_sale.setSelected(false);
                break;
            case 1:
                if (fragmentGameShopSale == null) {
                    fragmentGameShopSale = new FragmentGame_shop_sale();
                    ft.add(R.id.shop_content, fragmentGameShopSale);
                } else {
                    ft.show(fragmentGameShopSale);
                }
                btn_buy.setSelected(false);
                btn_sale.setSelected(true);
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (fragmentGameShopBuy != null) {
            ft.hide(fragmentGameShopBuy);
        }
        if (fragmentGameShopSale != null) {
            ft.hide(fragmentGameShopSale);
        }
    }
}
