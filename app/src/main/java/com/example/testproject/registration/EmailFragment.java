package com.example.testproject.registration;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class EmailFragment extends Fragment {

    private EditText inputText;
    private Button btnNext;
    private TextView tvOffer;
    private TextView tvPrompt;
    private ProgressBar progressBar;

    public EmailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration_email, container, false);

        inputText = view.findViewById(R.id.edit_text);
        btnNext = view.findViewById(R.id.btn_next);
        tvOffer = view.findViewById(R.id.tv_offer);
        tvPrompt = view.findViewById(R.id.tv_prompt);
        progressBar = view.findViewById(R.id.progress_bar);

        inputText.addTextChangedListener(new TextWatcher() {
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

        tvOffer.setOnClickListener(v -> Toast.makeText(getActivity(), "Link to offer", Toast.LENGTH_SHORT).show());

        btnNext.setOnClickListener(v -> {
            btnNext.setEnabled(false);
            hideSoftInput(view);
            progressBar.setVisibility(View.VISIBLE);
            btnNext.setText("");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    replaceFragment();
                    progressBar.setVisibility(View.GONE);
                    btnNext.setText("????????????????????");
                    btnNext.setEnabled(true);
                }
            }, 1000);
        });

        checkValidation();

        return view;
    }

    private void replaceFragment() {
        ((RegisterActivity) getActivity()).addFragment(PhoneFragment.newInstance(inputText.getText().toString().trim()));
    }

    public void hideSoftInput(final View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void checkValidation() {
        boolean isValid = false;
        if (inputText.length() > 0) {
            isValid = true;
        }

        inputText.setBackgroundResource(isValid ? R.drawable.corner_radius_10_purple_edittext : R.drawable.corner_radius_10_gray_edittext);

        tvPrompt.setText(isValid ? "??????????????! ?????????????? ???????????? ????????????????????" : "?????????? ?????????? ???? ?????????????? ?????????? ?? ????????????????????");
        tvPrompt.setTextColor(isValid ? Color.parseColor("#001AFF") : Color.parseColor("#959595"));

        btnNext.setEnabled(isValid);
        btnNext.setBackgroundResource(isValid ? R.drawable.button_enabled : R.drawable.button_disabled);
        btnNext.setTextColor(isValid ? Color.parseColor("#404040") : Color.parseColor("#696969"));
    }
}