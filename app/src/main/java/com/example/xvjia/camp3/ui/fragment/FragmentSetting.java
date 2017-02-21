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

public class FragmentSetting extends Fragment implements View.OnClickListener {


    private RadioButton rb_set, rb_account;
    private FragmentSetting_set fragmentSettingSet;
    private FragmentSetting_account fragmentSettingAccount;

    public FragmentSetting() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        initview(view);

        initListener();

        select(0);

        return view;
    }

    private void initListener() {
        rb_set.setOnClickListener(this);
        rb_account.setOnClickListener(this);
    }

    private void initview(View view) {
        rb_set = (RadioButton) view.findViewById(R.id.btn_set);
        rb_account = (RadioButton) view.findViewById(R.id.btn_account);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_set:
                select(0);
                break;
            case R.id.btn_account:
                select(1);
                break;
        }
    }

    private void select(int i) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        hideFragment(ft);

        switch (i) {
            case 0:
                if (fragmentSettingSet == null) {
                    fragmentSettingSet = new FragmentSetting_set();
                    ft.add(R.id.setting_content, fragmentSettingSet);
                } else {
                    ft.show(fragmentSettingSet);
                }
                rb_set.setChecked(true);
                rb_account.setChecked(false);
                break;
            case 1:
                if (fragmentSettingAccount == null) {
                    fragmentSettingAccount = new FragmentSetting_account();
                    ft.add(R.id.setting_content, fragmentSettingAccount);
                } else {
                    ft.show(fragmentSettingAccount);
                }
                rb_set.setChecked(false);
                rb_account.setChecked(true);
                break;
        }
        ft.commit();
    }

    private void hideFragment(FragmentTransaction ft) {
        if (fragmentSettingSet != null) {
            ft.hide(fragmentSettingSet);
        }
        if (fragmentSettingAccount != null) {
            ft.hide(fragmentSettingAccount);
        }
    }
}
