package com.example.testproject.registration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;
import com.example.testproject.main.MainActivity;

public class SuccessFragment extends Fragment {

    private String email;
    private String phone;

    public SuccessFragment() {
    }

    public static SuccessFragment newInstance(String email, String phone) {
        SuccessFragment fragment = new SuccessFragment();
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("phone", phone);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString("email");
            phone = getArguments().getString("phone");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_success, container, false);

        view.findViewById(R.id.btn_go).setOnClickListener(v -> MainActivity.start(getActivity()));

        return view;
    }
}