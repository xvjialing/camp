package com.example.xvjia.camp3.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.adapter.FriendAdapter;
import com.example.xvjia.camp3.bean.FriendBean;
import com.example.xvjia.camp3.ui.activity.Activity_friend1_detail;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.ToastUtils;
import com.example.xvjia.camp3.utils.UrlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentFriend_mine extends Fragment {
    private RecyclerView recyclerView;
    private List<FriendBean> friendList;
    private static final String URL = UrlUtils.Url + "friendList";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RequestUtils requestUtils;
    private FriendAdapter friendAdapter;
    private Map<String, String> params;
    private int page = 1;
    private static final String TAG = FragmentFriend.class.getSimpleName();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friend_mine, container, false);

        intView(view);

        swipeRefreshLayout.setRefreshing(true);

        updateData();

        initRefreshListener();

        return view;
    }

    private void initRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page++;
                params.clear();
                params.put("page", String.valueOf(page));
                requestUtils.request(params, URL).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                if (swipeRefreshLayout.isRefreshing()) {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                Log.d(TAG, "RefreshCompelete");
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (swipeRefreshLayout.isRefreshing()) {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                Log.d(TAG, e.getMessage());
                            }

                            @Override
                            public void onNext(String s) {
                                Log.d(TAG, s);
                                friendList = JSON.parseArray(s, FriendBean.class);
                                friendAdapter.notifyDataSetChanged();
                            }
                        });
            }
        });
    }

    private void intView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_friend);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void updateData() {
        params = new HashMap<>();
        params.put("page", String.valueOf(page));
        requestUtils = new RequestUtils();
        requestUtils.request(params, URL).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {

                    @Override
                    public void onCompleted() {
                        if (swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (swipeRefreshLayout.isRefreshing()) {
                            swipeRefreshLayout.setRefreshing(false);
                        }
                        Log.d(TAG, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, s);
                        friendList = JSON.parseArray(s, FriendBean.class);
                        friendAdapter = new FriendAdapter(getContext(), friendList);
                        friendAdapter.setOnButtonClickListener(new FriendAdapter.ButtonClickListener() {
                            @Override
                            public void ButtonCick(RecyclerView parent, View view, int position, FriendBean friendBean) {
                                Intent intent = new Intent(getContext(), Activity_friend1_detail.class);
                                startActivity(intent);
                            }
                        });
                        recyclerView.setAdapter(friendAdapter);
                    }
                });
    }


}
