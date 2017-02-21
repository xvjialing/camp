package com.example.xvjia.camp3.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.ui.activity.ActivityLogin;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSetting_account extends Fragment {


    private Button btn_exchangAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting_account, container, false);

        btn_exchangAccount = (Button) view.findViewById(R.id.exchangeAccount);
        btn_exchangAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityLogin.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

}
