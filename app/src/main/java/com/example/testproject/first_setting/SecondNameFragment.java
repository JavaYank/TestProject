package com.example.testproject.first_setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class SecondNameFragment extends Fragment {

    private Button btnNext;

    public SecondNameFragment() {
        // Required empty public constructor
    }

    public static SecondNameFragment newInstance() {
        return new SecondNameFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_second_name, container, false);

        btnNext = view.findViewById(R.id.btn_next);

        if (getActivity() != null) {
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(ThirdGreetingFragment.newInstance()));
        }

        return view;
    }
}