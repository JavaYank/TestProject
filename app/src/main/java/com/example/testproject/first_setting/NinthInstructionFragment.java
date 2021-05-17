package com.example.testproject.first_setting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;
import com.example.testproject.registration.SuccessFragment;

public class NinthInstructionFragment extends Fragment {

    private RelativeLayout openSettingLayout;
    private Button btnNext;

    public NinthInstructionFragment() {
        // Required empty public constructor
    }

    public static NinthInstructionFragment newInstance() {
        return new NinthInstructionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_ninth_instruction, container, false);
        openSettingLayout = view.findViewById(R.id.open_setting_layout);
        btnNext = view.findViewById(R.id.btn_next);

        if (getActivity() != null) {
            openSettingLayout.setOnClickListener(v -> onClickSetting(getActivity()));
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(SuccessFragment.newInstance(false)));
        }

        return view;
    }

    private void onClickSetting(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }
}