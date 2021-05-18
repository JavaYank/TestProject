package com.example.testproject.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.R;

import java.util.HashMap;
import java.util.Map;

public class GreetingSettingActivity extends AppCompatActivity {

    private TextView tvReady;
    private FrameLayout greeting1Layout;
    private FrameLayout greeting2Layout;
    private FrameLayout greeting3Layout;
    private FrameLayout greeting4Layout;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Button btnNext;
    private Map<FrameLayout, TextView> greetingMap = new HashMap<>();

    public static void start(Context context) {
        context.startActivity(new Intent(context, GreetingSettingActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting_setting);
        initView();

        greetingMap.put(greeting1Layout, tv1);
        greetingMap.put(greeting2Layout, tv2);
        greetingMap.put(greeting3Layout, tv3);
        greetingMap.put(greeting4Layout, tv4);

        greeting1Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting1Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv1.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting2Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting2Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv2.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting3Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting3Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv3.setTextColor(Color.parseColor("#FFFFFF"));
        });
        greeting4Layout.setOnClickListener(v -> {
            onClickGreeting();
            greeting4Layout.setBackgroundResource(R.drawable.corner_blue_dialog);
            tv4.setTextColor(Color.parseColor("#FFFFFF"));
        });

        greeting1Layout.callOnClick();

        tvReady.setOnClickListener(v -> finish());
        btnNext.setOnClickListener(v -> {});
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
        tvReady = findViewById(R.id.tv_ready);
        greeting1Layout = findViewById(R.id.greeting_1_layout);
        greeting2Layout = findViewById(R.id.greeting_2_layout);
        greeting3Layout = findViewById(R.id.greeting_3_layout);
        greeting4Layout = findViewById(R.id.greeting_4_layout);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
        tv4 = findViewById(R.id.tv_4);
        btnNext = findViewById(R.id.btn_next);
    }

    private void onClickGreeting() {
        for (Map.Entry<FrameLayout, TextView> item : greetingMap.entrySet()) {
            item.getKey().setBackgroundResource(R.drawable.corner_gray_dialog);
            item.getValue().setTextColor(Color.parseColor("#696969"));
        }
    }
}