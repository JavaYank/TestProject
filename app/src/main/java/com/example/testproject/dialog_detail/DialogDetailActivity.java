package com.example.testproject.dialog_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.testproject.R;
import com.example.testproject.utils.objects.MainDialogItem;

public class DialogDetailActivity extends AppCompatActivity {

    public static void start(Context context, MainDialogItem dialogItem) {
        Intent intent = new Intent(context, DialogDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_detail);
    }
}