package com.example.testproject.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testproject.R;

public class CallForwardingActivity extends AppCompatActivity {

    public static void start(Context context) {
        context.startActivity(new Intent(context, CallForwardingActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_forwarding);
        getWindow().setStatusBarColor(Color.parseColor("#FA00D43B"));
    }
}