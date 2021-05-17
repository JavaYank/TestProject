package com.example.testproject.subscribtion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SubscriptionActivity extends AppCompatActivity {

    private LinearLayout subsMonthLayout;
    private LinearLayout subsYearLayout;

    public static void start(Context context) {
        Intent intent = new Intent(context, SubscriptionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscription);
        initView();

        Window window = getWindow();
        window.setStatusBarColor(Color.parseColor("#FA00D43B"));

        subsMonthLayout.setOnClickListener(v -> {
            subsMonthLayout.setBackgroundResource(R.drawable.stroke_green);
            subsYearLayout.setBackgroundResource(R.drawable.corner_radius_gray);
        });

        subsYearLayout.setOnClickListener(v -> {
            subsMonthLayout.setBackgroundResource(R.drawable.corner_radius_gray);
            subsYearLayout.setBackgroundResource(R.drawable.stroke_green);
        });

        subsMonthLayout.callOnClick();
    }

    private void initView() {
        subsMonthLayout = findViewById(R.id.subs_month_layout);
        subsYearLayout = findViewById(R.id.subs_year_layout);
    }
}