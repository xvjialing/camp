package com.example.xvjia.camp3.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.ui.activity.ActivityAdd_camp;
import com.example.xvjia.camp3.ui.activity.ActivityGame_team;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNgame_mine extends Fragment {


    private Button btn_yingdi1;
    private Button btn_addCamp;

    public FragmentNgame_mine() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ngame_mine, container, false);


        initView(view);

        initListener();


        return view;
    }

    private void initListener() {
        btn_yingdi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityGame_team.class);
                startActivity(intent);
            }
        });

        btn_addCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityAdd_camp.class);
                startActivity(intent);
            }
        });
    }

    private void initView(View view) {
        btn_yingdi1 = (Button) view.findViewById(R.id.btn_Camp1);
        btn_addCamp = (Button) view.findViewById(R.id.btn_Camp_Creat);
    }

}
