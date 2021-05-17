package com.example.testproject.first_setting;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

import java.util.HashMap;
import java.util.Map;

public class ThirdGreetingFragment extends Fragment {

    private FrameLayout greeting1Layout;
    private FrameLayout greeting2Layout;
    private FrameLayout greeting3Layout;
    private FrameLayout greeting4Layout;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button btnNext;
    private Map<FrameLayout, TextView> greetingMap = new HashMap<>();

    public ThirdGreetingFragment() {
        // Required empty public constructor
    }

    public static ThirdGreetingFragment newInstance() {
        return new ThirdGreetingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_third_greeting, container, false);
        btnNext = view.findViewById(R.id.btn_next);
        greeting1Layout = view.findViewById(R.id.greeting_1_layout);
        greeting2Layout = view.findViewById(R.id.greeting_2_layout);
        greeting3Layout = view.findViewById(R.id.greeting_3_layout);
        greeting4Layout = view.findViewById(R.id.greeting_4_layout);
        tv1 = view.findViewById(R.id.tv_1);
        tv2 = view.findViewById(R.id.tv_2);
        tv3 = view.findViewById(R.id.tv_3);
        tv4 = view.findViewById(R.id.tv_4);
        greetingMap.put(greeting1Layout, tv1);
        greetingMap.put(greeting2Layout, tv2);
        greetingMap.put(greeting3Layout, tv3);
        greetingMap.put(greeting4Layout, tv4);

        greeting1Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting1Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv1.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting2Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting2Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv2.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting3Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting3Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv3.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting4Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting4Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv4.setTextColor(Color.parseColor("#FFFFFF"));
        });

        greeting1Layout.callOnClick();

        if (getActivity() != null) {
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(FourthPermissionFragment.newInstance()));
        }
        return view;
    }

    private void onClickGreeting() {
        for (Map.Entry<FrameLayout, TextView> item : greetingMap.entrySet()) {
            item.getKey().setBackgroundResource(R.drawable.corner_gray_dialog);
            item.getValue().setTextColor(Color.parseColor("#696969"));
        }
    }
}