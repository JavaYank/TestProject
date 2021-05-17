package com.example.testproject.registration;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;
import com.example.testproject.first_setting.FirstSettingActivity;
import com.example.testproject.main.MainActivity;

public class SuccessFragment extends Fragment {

    private TextView tvTitle;
    private Button btnGo;
    private boolean isRegistration;

    public SuccessFragment() {
    }

    public static SuccessFragment newInstance(boolean isRegistration) {
        SuccessFragment fragment = new SuccessFragment();
        Bundle args = new Bundle();
        args.putBoolean("is_registration", isRegistration);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isRegistration = getArguments().getBoolean("is_registration");
        }
        Window window = getActivity().getWindow();
        window.setStatusBarColor(Color.parseColor("#FA00D43B"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_success, container, false);
        tvTitle = view.findViewById(R.id.tv_title);
        btnGo = view.findViewById(R.id.btn_go);

        if (isRegistration) {
            tvTitle.setText("Поздравляем.\nВаш номер подтвержден.");
        } else {
            tvTitle.setText("Поздравляем.\nВы закончили настройку");
        }

        if (getActivity() != null) {
            btnGo.setOnClickListener(v -> {
                if (isRegistration) {
                    FirstSettingActivity.start(getActivity());
                } else {
                    MainActivity.start(getActivity());
                }
            });
        }

        return view;
    }
}