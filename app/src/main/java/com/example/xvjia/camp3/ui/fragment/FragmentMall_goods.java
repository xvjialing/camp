package com.example.xvjia.camp3.ui.fragment;


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
import com.example.xvjia.camp3.adapter.GoodsAdapter;
import com.example.xvjia.camp3.bean.GoodsBean;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.UrlUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentMall_goods extends Fragment {
    private List<GoodsBean> goodsList;
    private static final String URL = UrlUtils.Url + "goodslist";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RequestUtils requestUtils;
    private GoodsAdapter goodsAdapter;
    private int page = 1;
    private Map<String, String> params;

    private static final String TAG = FragmentMall_goods.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mall_goods, container, false);

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
                page++;
                params.clear();
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
                                Logger.d(e.getMessage());
                            }

                            @Override
                            public void onNext(String s) {
                                Logger.json(s);
                                int fromPosition = goodsList.size();
                                List<GoodsBean> list = JSON.parseArray(s, GoodsBean.class);
                                goodsList.addAll(list);
                                int toPosition = goodsList.size() - 1;
                                goodsAdapter.notifyItemRangeInserted(fromPosition, list.size());
                                recyclerView.smoothScrollToPosition(goodsList.size());
                            }
                        });
            }
        });
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
                        Logger.d(e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        Logger.json(s);
                        goodsList = JSON.parseArray(s, GoodsBean.class);
                        goodsAdapter = new GoodsAdapter(getContext(), goodsList);
                        goodsAdapter.setOnButtonCickListener(new GoodsAdapter.ButtonClickListener() {
                            @Override
                            public void ButtonClick(RecyclerView parent, View view, int position, GoodsBean goodsBean) {

                            }
                        });
                        recyclerView.setAdapter(goodsAdapter);
                        recyclerView.smoothScrollToPosition(0);
                    }
                });
    }

    private void initView(View view) {
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_goodslist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.smoothScrollToPosition(0);
    }

}
