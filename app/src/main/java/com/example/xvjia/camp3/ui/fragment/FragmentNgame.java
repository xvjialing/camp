package com.example.xvjia.camp3.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.xvjia.camp3.MyApplication;
import com.example.xvjia.camp3.R;

import java.lang.ref.WeakReference;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNgame extends Fragment implements View.OnClickListener {


    private FragmentNgame_mine fragmentNgameMine;
    private FragmentNgame_recommend fragmentNgameRecommend;
    private FragmentNgame_search fragmentNgameSearch;
    private RadioButton rb_mine, rb_recommend, rb_search;
    private MyApplication myApplication;
    private WeakReference weakReference = new WeakReference(myApplication);

    public FragmentNgame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ngame, container, false);

        initview(view);

        return view;
    }

    private void initListener() {
        rb_mine.setOnClickListener(this);
        rb_recommend.setOnClickListener(this);
        rb_search.setOnClickListener(this);
    }

    private void initview(View view) {
        rb_mine = (RadioButton) view.findViewById(R.id.btn_ngame_mine);
        rb_recommend = (RadioButton) view.findViewById(R.id.btn_ngame_recommend);
        rb_search = (RadioButton) view.findViewById(R.id.btn_ngame_search);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ngame_mine:
                select(0);
                break;
            case R.id.btn_ngame_recommend:
                select(1);
                break;
            case R.id.btn_ngame_search:
                select(2);
                break;
        }
    }

    private void select(int i) {

        FragmentManager fm = getFragmentManager();  //获得Fragment管理器
        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

        hidtFragment(ft);   //先隐藏 Fragment

        switch (i) {
            case 0:
                if (fragmentNgameMine == null) {
                    fragmentNgameMine = new FragmentNgame_mine();
                    ft.add(R.id.yingdi_content, fragmentNgameMine);
                } else {
                    ft.show(fragmentNgameMine);
                }
                rb_mine.setChecked(true);
                rb_recommend.setChecked(false);
                rb_search.setChecked(false);
                break;
            case 1:
                if (fragmentNgameRecommend == null) {
                    fragmentNgameRecommend = new FragmentNgame_recommend();
                    ft.add(R.id.yingdi_content, fragmentNgameRecommend);
                } else {
                    ft.show(fragmentNgameRecommend);
                }
                rb_mine.setChecked(false);
                rb_recommend.setChecked(true);
                rb_search.setChecked(false);
                break;
            case 2:
                if (fragmentNgameSearch == null) {
                    fragmentNgameSearch = new FragmentNgame_search();
                    ft.add(R.id.yingdi_content, fragmentNgameSearch);
                } else {
                    ft.show(fragmentNgameSearch);
                }
                rb_mine.setChecked(false);
                rb_recommend.setChecked(false);
                rb_search.setChecked(true);
                break;
        }
        ft.commit();
    }

    private void hidtFragment(FragmentTransaction ft) {
        if (fragmentNgameMine != null) {
            ft.hide(fragmentNgameMine);
        }
        if (fragmentNgameRecommend != null) {
            ft.hide(fragmentNgameRecommend);
        }
        if (fragmentNgameSearch != null) {
            ft.hide(fragmentNgameSearch);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        initListener();
        myApplication = (MyApplication) getActivity().getApplication();

        switch (myApplication.getHomefragmentTag()) {
            case 0:
                select(1);
                break;
            case 1:
                select(0);
                break;
            case 2:
                select(3);
                break;
        }
    }

    @Override
    public void onDestroy() {
        fragmentNgameMine = null;
        fragmentNgameRecommend = null;
        fragmentNgameSearch = null;
        myApplication = null;
        super.onDestroy();
    }
}
