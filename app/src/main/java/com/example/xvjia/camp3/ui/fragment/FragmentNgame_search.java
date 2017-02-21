package com.example.xvjia.camp3.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.xvjia.camp3.R;

public class FragmentNgame_search extends Fragment {

    private EditText search_Edit;
    private Button search_Btn;
    private RelativeLayout quick_searcj_Rela;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ngame_search, container, false);

        initView(view);

        initListener();

        return view;
    }

    private void initView(View view) {
        search_Edit = (EditText) view.findViewById(R.id.edt_campname);
        search_Btn = (Button) view.findViewById(R.id.btn_search);
        quick_searcj_Rela = (RelativeLayout) view.findViewById(R.id.yingdi_qiuck_search);
    }

    private void initListener() {
        search_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(search_Edit.getText())) {
                    Toast.makeText(getContext(), "营地名称不能为空！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
