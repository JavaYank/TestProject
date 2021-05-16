package com.example.testproject.first_setting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.testproject.R;

public class SixthCallSetFragment extends Fragment {

    private Button btnNext;

    public SixthCallSetFragment() {
        // Required empty public constructor
    }

    public static SixthCallSetFragment newInstance() {
        return new SixthCallSetFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_sixth_call_set, container, false);
        btnNext = view.findViewById(R.id.btn_next);
        if (getActivity() != null) {
            btnNext.setOnClickListener(v -> ((FirstSettingActivity)getActivity()).addFragment(SeventhPhoneSettingFragment.newInstance()));
        }
        return view;
    }
}