package com.example.xvjia.camp3.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.utils.AppUtils;

public class FragmentSetting_set extends Fragment implements View.OnClickListener {

    private TextView tv_version;
    private Button btn_update;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting_set, container, false);
        tv_version = (TextView) view.findViewById(R.id.txt_Text1);
        tv_version.setText("当前版本：" + AppUtils.getVersionName(getContext()));

        btn_update = (Button) view.findViewById(R.id.btn_update);

        btn_update.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:

                break;
        }
    }
}
