package com.example.testproject.dialog_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.dialog_detail.adapter.RecyclerViewDialogAdapter;
import com.example.testproject.utils.objects.MainDialogItem;
import com.example.testproject.utils.objects.MainDialogListItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class DialogDetailActivity extends AppCompatActivity {

    private TextView tvPhone;
    private RecyclerView recyclerView;
    private MainDialogListItem dialogItem;

    public static void start(Context context, MainDialogListItem dialogItem) {
        Intent intent = new Intent(context, DialogDetailActivity.class);
        String json = new Gson().toJson(dialogItem);
        intent.putExtra("json", json);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_detail);
        initView();

        if (getIntent() != null) {
            String json = getIntent().getStringExtra("json");
            dialogItem = new Gson().fromJson(json, MainDialogListItem.class);
            tvPhone.setText(dialogItem.getTitle());
        }

        RecyclerViewDialogAdapter adapter = new RecyclerViewDialogAdapter(getDialogList());
        adapter.setListener(item -> {

        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private List<MainDialogItem> getDialogList() {
        List<MainDialogItem> list = new ArrayList<>();
        list.add(new MainDialogItem(true, "Айлло. Я цифровой ассистент абонента. Уточните, пожалуйста, ваше имя и цель вашего звонка"));
        list.add(new MainDialogItem(false, "Добрый день. Хочу записаться к вам на прием."));
        list.add(new MainDialogItem(true, "Запишитесь"));
        list.add(new MainDialogItem(false, "ок"));
        list.add(new MainDialogItem(false, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."));
        list.add(new MainDialogItem(true, "вне зоны доступа\nмы все опознаны\nвне зоне доступа\nмы"));
        return list;
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
        tvPhone = findViewById(R.id.tv_phone);
        recyclerView = findViewById(R.id.rv_dialog_list);
    }
}