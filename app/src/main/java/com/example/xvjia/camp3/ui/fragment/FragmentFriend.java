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
public class FragmentFriend extends Fragment implements View.OnClickListener {

    private FragmentFriend_mine fragmentFriendMine;
    private FragmentFriend_rank fragmentFriendRank;
    private FragmentFriend_search fragmentFriendSearch;

    private RadioButton rb_friendMine, rb_friendRank, rb_friendSearch;


    public FragmentFriend() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);

        initView(view);

        initListener();
        select(0);
        return view;
    }

    private void initView(View view) {
        rb_friendMine = (RadioButton) view.findViewById(R.id.btn_friendMine);
        rb_friendRank = (RadioButton) view.findViewById(R.id.btn_friend_rank);
        rb_friendSearch = (RadioButton) view.findViewById(R.id.btn_friend_Search);
    }

    private void initListener() {
        rb_friendMine.setOnClickListener(this);
        rb_friendRank.setOnClickListener(this);
        rb_friendSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_friendMine:
                select(0);
                break;
            case R.id.btn_friend_rank:
                select(1);
                break;
            case R.id.btn_friend_Search:
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
                if (fragmentFriendMine == null) {
                    fragmentFriendMine = new FragmentFriend_mine();
                    ft.add(R.id.friend_content, fragmentFriendMine);
                } else {
                    ft.show(fragmentFriendMine);
                }
                rb_friendMine.setChecked(true);
                rb_friendRank.setChecked(false);
                rb_friendSearch.setChecked(false);
                break;
            case 1:
                if (fragmentFriendRank == null) {
                    fragmentFriendRank = new FragmentFriend_rank();
                    ft.add(R.id.friend_content, fragmentFriendRank);
                } else {
                    ft.show(fragmentFriendRank);
                }
                rb_friendMine.setChecked(false);
                rb_friendRank.setChecked(true);
                rb_friendSearch.setChecked(false);
                break;
            case 2:
                if (fragmentFriendSearch == null) {
                    fragmentFriendSearch = new FragmentFriend_search();
                    ft.add(R.id.friend_content, fragmentFriendSearch);
                } else {
                    ft.show(fragmentFriendSearch);
                }
                rb_friendMine.setChecked(false);
                rb_friendRank.setChecked(false);
                rb_friendSearch.setChecked(true);
                break;

        }

        ft.commit();
    }

    private void hidtFragment(FragmentTransaction ft) {
        if (fragmentFriendMine != null) {
            ft.hide(fragmentFriendMine);
        }
        if (fragmentFriendRank != null) {
            ft.hide(fragmentFriendRank);
        }
        if (fragmentFriendSearch != null) {
            ft.hide(fragmentFriendSearch);
        }
    }
}
