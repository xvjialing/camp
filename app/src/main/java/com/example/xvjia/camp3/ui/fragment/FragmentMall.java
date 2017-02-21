package com.example.xvjia.camp3.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.xvjia.camp3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMall extends Fragment implements View.OnClickListener {


    private FragmentMall_goods fragmentMallGoods;
    private FragmentMall_bag fragmentMallBag;
    private RadioButton rb_goods, rb_bag;

    public FragmentMall() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mall, container, false);

        initview(view);

        initListener();

        Select(0);

        return view;
    }

    private void initview(View view) {
        rb_goods = (RadioButton) view.findViewById(R.id.btn_Mall_goods);
        rb_bag = (RadioButton) view.findViewById(R.id.btn_mall_bag);
    }


    private void initListener() {
        rb_goods.setOnClickListener(this);
        rb_bag.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_Mall_goods:
                Select(0);
                break;
            case R.id.btn_mall_bag:
                Select(1);
                break;
        }
    }

    private void Select(int i) {
        FragmentManager fm = getFragmentManager();  //获得Fragment管理器
        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

        hidtFragment(ft);   //先隐藏 Fragment

        switch (i) {
            case 0:
                if (fragmentMallGoods == null) {
                    fragmentMallGoods = new FragmentMall_goods();
                    ft.add(R.id.mall_content, fragmentMallGoods);
                } else {
                    ft.show(fragmentMallGoods);
                }
                rb_goods.setChecked(true);
                rb_bag.setChecked(false);
                break;
            case 1:
                if (fragmentMallBag == null) {
                    fragmentMallBag = new FragmentMall_bag();
                    ft.add(R.id.mall_content, fragmentMallBag);
                } else {
                    ft.show(fragmentMallBag);
                }
                rb_goods.setChecked(false);
                rb_bag.setChecked(true);
                break;
        }
        ft.commit();
    }

    private void hidtFragment(FragmentTransaction ft) {
        if (fragmentMallGoods != null) {
            ft.hide(fragmentMallGoods);
        }
        if (fragmentMallBag != null) {
            ft.hide(fragmentMallBag);
        }
    }
}
