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
import com.example.xvjia.camp3.bean.FriendBean;
import com.example.xvjia.camp3.utils.UrlUtils;
import com.squareup.haha.trove.THash;

import java.util.List;

/**
 * Created by xjl on 17-2-7.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {
    private Context mContext;
    private List<FriendBean> friendList;

    private RecyclerView recyclerView;
    private ButtonClickListener buttonClickListener;

    public interface ButtonClickListener {
        void ButtonCick(RecyclerView parent, View view, int position, FriendBean friendBean);
    }

    public void setOnButtonClickListener(ButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public FriendAdapter(Context mContext, List<FriendBean> friendList) {
        this.mContext = mContext;
        this.friendList = friendList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_friend, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Glide.with(mContext).load(UrlUtils.IMAGEBASE + friendList.get(position).getAvater()).into(holder.iv_avater);
        holder.tv_name.setText(friendList.get(position).getName());
        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListener.ButtonCick(recyclerView, v, position, friendList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return friendList.size();
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_avater;
        private TextView tv_name;
        private Button btn_detail;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_avater = (ImageView) itemView.findViewById(R.id.iv_avater);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            btn_detail = (Button) itemView.findViewById(R.id.btn_detail);
        }
    }
}
