package com.example.testproject.first_setting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testproject.R;

public class ThirdGreetingFragment extends Fragment {

    private Button btnNext;

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
        if (getActivity() != null) {
            btnNext.setOnClickListener(v -> ((FirstSettingActivity)getActivity()).addFragment(FourthPermissionFragment.newInstance()));
        }
        return view;
    }
}