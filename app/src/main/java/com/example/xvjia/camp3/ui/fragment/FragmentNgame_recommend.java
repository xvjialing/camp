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
import com.example.xvjia.camp3.adapter.YingdiAdapter;
import com.example.xvjia.camp3.bean.GameBean;
import com.example.xvjia.camp3.ui.activity.ActivityNgame_place1_detail;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.UrlUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentNgame_recommend extends Fragment {

    private List<GameBean> gameList;

    private static final String URL = UrlUtils.Url + "yingdilist";
    private RecyclerView recyclerView;
    private RequestUtils requestUtils;
    private YingdiAdapter yingdiAdapter;
    private Map<String, String> params;

    private static final String TAG = FragmentNgame_recommend.class.getSimpleName();
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngame_recommend, container, false);

        initView(view);
        swipeRefreshLayout.setRefreshing(true);
        updateData();

        initRefreshListener();

        return view;
    }

    private void initRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestUtils.request(params, URL).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {
                                if (swipeRefreshLayout.isRefreshing()) {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                Logger.d("RefreshCompelete");
                            }

                            @Override
                            public void onError(Throwable e) {
                                if (swipeRefreshLayout.isRefreshing()) {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                                Logger.d(e.getMessage());
                            }

                            @Override
                            public void onNext(String s) {
                                Logger.json(s);
                                gameList = JSON.parseArray(s, GameBean.class);
                                Log.d(TAG, String.valueOf(gameList.size()));
                                yingdiAdapter.notifyDataSetChanged();
                            }
                        });
            }
        });
    }

    private void updateData() {
        params = new HashMap<>();
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
                        Logger.d(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Logger.json(s);
                        gameList = JSON.parseArray(s, GameBean.class);
                        Log.d(TAG, String.valueOf(gameList.size()));
                        yingdiAdapter = new YingdiAdapter(getContext(), gameList);
                        yingdiAdapter.setOnButtonClickListener(new YingdiAdapter.ButtonClickListener() {
                            @Override
                            public void buttonClick(RecyclerView parent, View view, int position, GameBean game) {
                                Log.d(TAG, String.valueOf(position));
                                Intent intent = new Intent(getContext(), ActivityNgame_place1_detail.class);
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("game", game);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });

                        recyclerView.setAdapter(yingdiAdapter);
                    }
                });
    }

    private void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_gamelist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
