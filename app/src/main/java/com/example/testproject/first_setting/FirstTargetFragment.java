package com.example.testproject.first_setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;


public class FirstTargetFragment extends Fragment {

    private RelativeLayout workPhoneLayout;
    private RelativeLayout personalPhoneLayout;
    private Button btnNext;

    public FirstTargetFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_first_target, container, false);
        workPhoneLayout = view.findViewById(R.id.work_phone_layout);
        personalPhoneLayout = view.findViewById(R.id.personal_phone_layout);
        btnNext = view.findViewById(R.id.btn_next);

        workPhoneLayout.setOnClickListener(v -> {
            workPhoneLayout.setBackgroundResource(R.drawable.stroke_blue);
            personalPhoneLayout.setBackgroundResource(R.drawable.stroke_gray);
        });

        personalPhoneLayout.setOnClickListener(v -> {
            workPhoneLayout.setBackgroundResource(R.drawable.stroke_gray);
            personalPhoneLayout.setBackgroundResource(R.drawable.stroke_blue);
        });

        workPhoneLayout.callOnClick();

        if (getActivity() != null) {
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(SecondNameFragment.newInstance()));
        }
        return view;
    }
}