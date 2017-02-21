package com.example.xvjia.camp3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.GoodsBean;
import com.example.xvjia.camp3.utils.UrlUtils;

import java.util.List;

/**
 * Created by xjl on 17-2-8.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.MyViewHolder> {
    private Context mContext;
    private List<GoodsBean> goodsList;
    private RecyclerView recyclerView;
    private ButtonClickListener buttonClickListener;

    public GoodsAdapter(Context mContext, List<GoodsBean> goodsList) {
        this.mContext = mContext;
        this.goodsList = goodsList;
    }

    public interface ButtonClickListener {
        void ButtonClick(RecyclerView parent, View view, int position, GoodsBean goodsBean);
    }

    public void setOnButtonCickListener(ButtonClickListener buttonCickListener) {
        this.buttonClickListener = buttonCickListener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public GoodsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods, parent, false);
        return new GoodsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GoodsAdapter.MyViewHolder holder, final int position) {
        Glide.with(mContext).load(UrlUtils.IMAGEBASE + goodsList.get(position).getPic()).into(holder.iv_goods);
        holder.tv_name.setText(goodsList.get(position).getName());
        holder.tv_price.setText(goodsList.get(position).getPrice());
        holder.btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListener.ButtonClick(recyclerView, v, position, goodsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_goods;
        private TextView tv_name;
        private TextView tv_price;
        private Button btn_details;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_goods = (ImageView) itemView.findViewById(R.id.iv_goods);
            tv_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            btn_details = (Button) itemView.findViewById(R.id.btn_goods);
        }
    }
}
