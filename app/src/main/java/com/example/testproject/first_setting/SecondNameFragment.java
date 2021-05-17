package com.example.testproject.first_setting;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class SecondNameFragment extends Fragment {

    private LinearLayout skipLayout;
    private EditText inputName;
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
        skipLayout = view.findViewById(R.id.skip_layout);
        inputName = view.findViewById(R.id.edit_text);
        btnNext = view.findViewById(R.id.btn_next);

        if (getActivity() != null) {
            skipLayout.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(ThirdGreetingFragment.newInstance()));
            btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(ThirdGreetingFragment.newInstance()));
        }

        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkValidation();
            }
        });

        checkValidation();

        return view;
    }

    private void checkValidation() {
        boolean isValid = false;
        if (inputName.length() > 0) {
            isValid = true;
        }

        btnNext.setBackgroundResource(isValid ? R.drawable.button_enabled : R.drawable.button_disabled);
        btnNext.setTextColor(isValid ? Color.parseColor("#404040") : Color.parseColor("#696969"));
        btnNext.setEnabled(isValid);
    }
}