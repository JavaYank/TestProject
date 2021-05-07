package com.example.testproject.startup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testproject.R;
import com.example.testproject.registration.RegisterActivity;
import com.example.testproject.startup.adapter.ScreenSlidePagerAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout skipLayout;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        CircleIndicator3 indicator = (CircleIndicator3) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());

        skipLayout.setOnClickListener(v -> skipStartUp());
        btnNext.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() == 2) {
                skipStartUp();
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        });
    }

    private void skipStartUp() {
        if (btnNext.isEnabled()) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
        btnNext.setEnabled(false);
    }

    private void initView() {
        skipLayout = findViewById(R.id.skip_layout);
        btnNext = findViewById(R.id.btn_next);
        viewPager = findViewById(R.id.pager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnNext.setEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}