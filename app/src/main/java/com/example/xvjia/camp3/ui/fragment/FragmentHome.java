package com.example.xvjia.camp3.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.ui.activity.ActivityClan;
import com.example.xvjia.camp3.ui.activity.ActivityRecord;

public class FragmentHome extends Fragment implements View.OnClickListener {

    private Button btn_clan, btn_huodong, btn_strategy, btn_record;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initView(View view) {
        btn_clan = (Button) view.findViewById(R.id.btn_home_clan);
        btn_huodong = (Button) view.findViewById(R.id.btn_home_huodong);
        btn_strategy = (Button) view.findViewById(R.id.btn_home_strategy);
        btn_record = (Button) view.findViewById(R.id.btn_home_record);

    }

    private void initListener() {
        btn_clan.setOnClickListener(this);
        btn_huodong.setOnClickListener(this);
        btn_strategy.setOnClickListener(this);
        btn_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_home_clan:
                intent = new Intent(getContext(), ActivityClan.class);
                startActivity(intent);
                break;
            case R.id.btn_home_huodong:
                //intent=new Intent(getContext(), ActivityHuodong.class);
                //startActivity(intent);
                //getActivity().finish();
                break;
            case R.id.btn_home_record:
                intent = new Intent(getContext(), ActivityRecord.class);
                startActivity(intent);
                break;
            case R.id.btn_home_strategy:
                //intent=new Intent(getContext(), ActivityStrategy.class);
                //startActivity(intent);
                //getActivity().finish();
                break;

        }
    }


}
