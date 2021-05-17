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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class SeventhPhoneSettingFragment extends Fragment {

    private LinearLayout openSettingLayout1;
    private RelativeLayout openSettingLayout2;
    private Button btnNext;

    public SeventhPhoneSettingFragment() {
        // Required empty public constructor
    }

    public static SeventhPhoneSettingFragment newInstance() {
        return new SeventhPhoneSettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_seventh_phone_setting, container, false);
        openSettingLayout1 = view.findViewById(R.id.open_setting_layout1);
        openSettingLayout2 = view.findViewById(R.id.open_setting_layout2);
        btnNext = view.findViewById(R.id.btn_next);

        if (getActivity() != null) {
            openSettingLayout1.setOnClickListener(v -> onClickSetting(getActivity()));
            openSettingLayout2.setOnClickListener(v -> onClickSetting(getActivity()));
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(EighthPhoneSettingFragment.newInstance()));
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