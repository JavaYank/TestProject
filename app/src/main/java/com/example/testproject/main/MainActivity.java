package com.example.testproject.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.testproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private int currentVisibleFragment = 0;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomListener);
        bottomNavigationView.setSelectedItemId(R.id.action_dialog);
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomListener = menuItem -> {
        switch (menuItem.getItemId()) {
            case R.id.action_dialog:
                replaceFragment(DialogListFragment.newInstance());
                break;
            case R.id.action_account:
                replaceFragment(AccountFragment.newInstance());
                break;
            case R.id.action_settings:
                replaceFragment(SettingFragment.newInstance());
                break;
        }
        currentVisibleFragment = menuItem.getItemId();
        return true;
    };

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (currentVisibleFragment == R.id.action_dialog) {
            super.onBackPressed();
        } else {
            bottomNavigationView.setSelectedItemId(R.id.action_dialog);
        }
    }
}