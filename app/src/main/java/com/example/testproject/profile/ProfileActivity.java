package com.example.testproject.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvReady;
    private TextView tvPhone;
    private TextView tvName;
    private TextView tvEmail;
    private ImageView imgSetName;
    private ImageView imgSetEmail;

    public static void start(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();

        tvReady.setOnClickListener(v -> finish());
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
        tvReady = findViewById(R.id.tv_ready);
        tvPhone = findViewById(R.id.tv_phone);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        imgSetName = findViewById(R.id.img_setting_name);
        imgSetEmail = findViewById(R.id.img_setting_email);

    }
}