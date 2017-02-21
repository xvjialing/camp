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
import com.example.xvjia.camp3.bean.GameBean;
import com.example.xvjia.camp3.utils.UrlUtils;

import java.util.List;

/**
 * Created by xjl on 2017/1/22.
 */

public class YingdiAdapter extends RecyclerView.Adapter<YingdiAdapter.MyViewHolder> {
    private Context mContext;
    private List<GameBean> gamelist;

    private RecyclerView recyclerView;
    private ButtonClickListener buttonClickListener;

    public interface ButtonClickListener {
        void buttonClick(RecyclerView parent, View view, int position, GameBean game); //最后的参数是list中的泛型
    }

    public void setOnButtonClickListener(ButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public YingdiAdapter(Context mContext, List<GameBean> gamelist) {
        this.mContext = mContext;
        this.gamelist = gamelist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_game, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Glide.with(mContext).load(UrlUtils.IMAGEBASE + gamelist.get(position).getLogo()).into(holder.iv_logo);
        holder.tv_title.setText(gamelist.get(position).getTitle());
        holder.tv_price.setText("价格：￥" + gamelist.get(position).getPrice());
        holder.tv_gametype.setText(gamelist.get(position).getType());
        holder.btn_describe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClickListener.buttonClick(recyclerView, v, position, gamelist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return gamelist.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_logo;
        private TextView tv_title;
        private TextView tv_price;
        private TextView tv_gametype;
        private Button btn_describe;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            tv_gametype = (TextView) itemView.findViewById(R.id.tv_gametype);
            btn_describe = (Button) itemView.findViewById(R.id.btn_describe);
        }
    }
}
