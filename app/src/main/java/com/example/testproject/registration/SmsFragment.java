package com.example.testproject.registration;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;
import com.example.testproject.utils.Constants;

public class SmsFragment extends Fragment {

    private String email;
    private String phone;
    private boolean resendSms = false;

    private EditText inputSmsCode;
    private Button btnSend;
    private Button btnSms;
    private RelativeLayout btnSendLayout;
    private RelativeLayout btnSmsLayout;
    private TextView tvCounter;
    private ProgressBar progressBarSend;
    private TextView tvPrompt;

    public SmsFragment() {
        // Required empty public constructor
    }

    public static SmsFragment newInstance(String email, String phone) {
        SmsFragment fragment = new SmsFragment();
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
        View view = inflater.inflate(R.layout.fragment_sms, container, false);
        initView(view);

        inputSmsCode.addTextChangedListener(new TextWatcher() {
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

        countDown();

        checkValidation();

        btnSend.setOnClickListener(v -> {
            btnSend.setEnabled(false);
            hideSoftInput(view);
            progressBarSend.setVisibility(View.VISIBLE);
            btnSend.setText("");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    replaceFragment();
                    progressBarSend.setVisibility(View.GONE);
                    btnSend.setText("Отправить");
                    btnSend.setEnabled(true);
                }
            }, 2000);
        });

        return view;
    }

    private void initView(View view) {
        inputSmsCode = view.findViewById(R.id.edit_text);
        btnSend = view.findViewById(R.id.btn_send);
        btnSms = view.findViewById(R.id.btn_sms);
        btnSendLayout = view.findViewById(R.id.btn_send_layout);
        btnSmsLayout = view.findViewById(R.id.btn_sms_layout);
        tvCounter = view.findViewById(R.id.tv_counter);
        progressBarSend = view.findViewById(R.id.progress_bar_send);
        tvPrompt = view.findViewById(R.id.tv_prompt);
    }

    private void replaceFragment() {
        ((RegisterActivity) getActivity()).addFragment(SuccessFragment.newInstance(email, phone));
    }

    public void hideSoftInput(final View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void countDown() {
        new CountDownTimer(Constants.COUNT_DOWN_MS_FOR_SMS, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) (millisUntilFinished / 1000) / 60;

                String text = (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds < 10 ? "0" + seconds : seconds);
                tvCounter.setText(text);
            }

            @Override
            public void onFinish() {
                resendSms = true;
                checkValidation();
            }
        }.start();
    }

    private void checkValidation() {
        boolean isValid = false;
        if (inputSmsCode.length() == 6) {
            btnSmsLayout.setVisibility(View.GONE);
            isValid = true;
        } else {
            btnSmsLayout.setVisibility(View.VISIBLE);
        }

        Log.d("TAG", "checkValidation: " + isValid);
        tvPrompt.setVisibility(isValid ? View.VISIBLE : View.GONE);
        tvCounter.setVisibility(isValid ? View.GONE : View.VISIBLE);

        btnSend.setEnabled(isValid);
        btnSend.setBackgroundResource(isValid ? R.drawable.button_enabled : R.drawable.button_disabled);

        btnSms.setEnabled(resendSms);
        btnSms.setBackgroundResource(resendSms ? R.drawable.button_enabled : R.drawable.button_disabled);
    }
}