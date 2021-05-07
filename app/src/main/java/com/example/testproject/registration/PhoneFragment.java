package com.example.testproject.registration;

import android.annotation.SuppressLint;
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

import org.jetbrains.annotations.NotNull;

public class PhoneFragment extends Fragment {

    private String email;
    private EditText inputPhone;
    private TextView tvPrompt;
    private TextView tvOffer;
    private Button btnNext;
    private ProgressBar progressBar;

    public PhoneFragment() {
        // Required empty public constructor
    }

    public static PhoneFragment newInstance(String email) {
        PhoneFragment fragment = new PhoneFragment();
        Bundle args = new Bundle();
        args.putString("email", email);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString("email");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container, false);

        inputPhone = view.findViewById(R.id.edit_text);
        tvPrompt = view.findViewById(R.id.tv_prompt);
        tvOffer = view.findViewById(R.id.tv_offer);
        btnNext = view.findViewById(R.id.btn_next);
        progressBar = view.findViewById(R.id.progress_bar);

        inputPhone.setText("+");
        inputPhone.setSelection(inputPhone.length());
        inputPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(@NotNull Editable s) {
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
                    btnNext.setText("Продолжить");
                    btnNext.setEnabled(true);
                }
            }, 2000);
        });

        checkValidation();

        return view;
    }

    private void replaceFragment() {
        ((RegisterActivity) getActivity()).addFragment(SuccessFragment.newInstance(email, inputPhone.getText().toString().trim()));
    }

    public void hideSoftInput(final View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void checkValidation() {
        boolean isValid = false;

        if (inputPhone.length() == 0) {
            inputPhone.setText("+");
            inputPhone.setSelection(1);
        } else if (!inputPhone.getText().toString().startsWith("+")) {
            if (inputPhone.getText().toString().contains("+")) {
                inputPhone.setText(inputPhone.getText().toString().substring(inputPhone.getText().toString().indexOf("+")));
            } else {
                inputPhone.setText("+" + inputPhone.getText().toString());
            }
            inputPhone.setSelection(inputPhone.getText().length());
        }

        if (inputPhone.length() > 1) {
            isValid = true;
        }

        inputPhone.setBackgroundResource(isValid ? R.drawable.corner_radius_10_purple_edittext : R.drawable.corner_radius_10_gray_edittext);

        tvPrompt.setText(isValid ? "Отлично! Нажмите кнопку Продолжить" : "После этого вы сможете войти в приложение");
        tvPrompt.setTextColor(isValid ? Color.parseColor("#001AFF") : Color.parseColor("#959595"));

        btnNext.setEnabled(isValid);
        btnNext.setBackgroundResource(isValid ? R.drawable.corner_radius_10_white : R.drawable.corner_radius_10_gray);
        btnNext.setTextColor(isValid ? Color.parseColor("#404040") : Color.parseColor("#696969"));
    }
}