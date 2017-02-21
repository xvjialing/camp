package com.example.xvjia.camp3.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.ui.activity.Activity_rank1_detail;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFriend_rank extends Fragment {


    public FragmentFriend_rank() {
        // Required empty public constructor
    }

    private Button btn_invite1, btn_invite2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_rank, container, false);

        initView(view);

        initListener();


        return view;
    }

    private void initView(View view) {
        btn_invite1 = (Button) view.findViewById(R.id.btn_Rank1);
        btn_invite2 = (Button) view.findViewById(R.id.btn_Rank2);
    }

    private void initListener() {
        btn_invite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getContext(), Activity_rank1_detail.class);
                startActivity(intent);
            }
        });
        btn_invite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
