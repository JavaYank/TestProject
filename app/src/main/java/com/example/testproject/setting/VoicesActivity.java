package com.example.testproject.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.utils.objects.VoiceItem;
import com.example.testproject.setting.adapter.RecyclerViewVoicesAdapter;

import java.util.ArrayList;
import java.util.List;

public class VoicesActivity extends AppCompatActivity {

    private TextView tvReady;
    private RecyclerView recyclerView;
    private int selectedItem = -1;

    public static void start(Context context) {
        context.startActivity(new Intent(context, VoicesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voices);
        initView();

        tvReady.setOnClickListener(v -> finish());

        RecyclerViewVoicesAdapter adapter = new RecyclerViewVoicesAdapter(getVoiceList());
        adapter.setListener(position -> {
            selectedItem = position;
            checkValidation();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private List<VoiceItem> getVoiceList() {
        List<VoiceItem> list = new ArrayList<>();
        list.add(new VoiceItem(R.mipmap.img_voice_vera, "Вера"));
        list.add(new VoiceItem(R.mipmap.img_voice_maria, "Мария"));
        list.add(new VoiceItem(R.mipmap.img_voice_ivan, "Иван"));
        list.add(new VoiceItem(R.mipmap.img_voice_mark, "Марк"));
        list.add(new VoiceItem(R.mipmap.img_voice_jesica, "Джессика"));
        return list;
    }

    private void checkValidation() {

    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
        tvReady = findViewById(R.id.tv_ready);
        recyclerView = findViewById(R.id.recycler_voices);
    }
}