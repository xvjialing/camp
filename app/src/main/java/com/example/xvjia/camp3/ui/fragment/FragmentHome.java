package com.example.xvjia.camp3.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.xvjia.camp3.R;
import com.example.xvjia.camp3.bean.UserInfoBean;
import com.example.xvjia.camp3.ui.activity.ActivityClan;
import com.example.xvjia.camp3.ui.activity.ActivityRecord;
import com.example.xvjia.camp3.utils.RequestUtils;
import com.example.xvjia.camp3.utils.SharedPreferencesUtils;
import com.example.xvjia.camp3.utils.UrlUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FragmentHome extends Fragment implements View.OnClickListener {

    private Button btn_clan, btn_huodong, btn_strategy, btn_record;
    private TextView tv_physical_damage;
    private TextView tv_physical_defense;
    private TextView tv_spell_damage;
    private TextView tv_spell_defense;
    private TextView tv_speed;
    private TextView tv_treatment_intensity;

    private static final String TAG=FragmentHome.class.getSimpleName();

    private static final String URL_USERINFO= UrlUtils.Url+"watchInfo";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);

        initData();

        initListener();

        return view;
    }

    private void initData() {
        final AlertDialog dialog=new AlertDialog.Builder(getContext())
                .setMessage("正在加载")
                .show();
        RequestUtils requestUtils=new RequestUtils();
        Map<String,String> map=new HashMap<>();
        String userid= SharedPreferencesUtils.getParam(getContext(),"userid","").toString();
        map.put("id",userid);
        requestUtils.request(map,URL_USERINFO)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG,s);
                        UserInfoBean userInfoBean= JSON.parseObject(s,UserInfoBean.class);
                        if (TextUtils.equals("0",String.valueOf(userInfoBean.getLp()))){
                            String physical_damage=userInfoBean.getData().get(0).getPhysical_damage();
                            String physical_defense=userInfoBean.getData().get(0).getPhysical_defense();
                            String spell_damage=userInfoBean.getData().get(0).getSpell_damage();
                            String spell_defense=userInfoBean.getData().get(0).getSpell_defense();
                            String speed=userInfoBean.getData().get(0).getSpeed();
                            String treatment_intensity=userInfoBean.getData().get(0).getTreatment_intensity();

                            tv_physical_damage.setText(physical_damage);
                            tv_physical_defense.setText(physical_defense);
                            tv_spell_damage.setText(spell_damage);
                            tv_spell_defense.setText(spell_defense);
                            tv_speed.setText(speed);
                            tv_treatment_intensity.setText(treatment_intensity);
                        }
                    }
                });
    }

    private void initView(View view) {
        btn_clan = (Button) view.findViewById(R.id.btn_home_clan);
        btn_huodong = (Button) view.findViewById(R.id.btn_home_huodong);
        btn_strategy = (Button) view.findViewById(R.id.btn_home_strategy);
        btn_record = (Button) view.findViewById(R.id.btn_home_record);

        tv_physical_damage = (TextView) view.findViewById(R.id.tv_physical_damage);
        tv_physical_defense = (TextView)view.findViewById(R.id.tv_physical_defense);
        tv_spell_damage = (TextView)view.findViewById(R.id.tv_spell_damage);
        tv_spell_defense = (TextView)view.findViewById(R.id.tv_spell_defense);
        tv_speed = (TextView)view.findViewById(R.id.tv_speed);
        tv_treatment_intensity = (TextView)view.findViewById(R.id.tv_treatment_intensity);
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
