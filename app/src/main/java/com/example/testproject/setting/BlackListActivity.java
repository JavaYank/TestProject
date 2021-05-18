package com.example.testproject.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.setting.adapter.RecyclerViewBlackListAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BlackListActivity extends AppCompatActivity {

    private TextView tvReady;
    private RecyclerView rvBlackList;
    private RecyclerViewBlackListAdapter adapter;
    List<String> list = new ArrayList<>();

    public static void start(Context context) {
        context.startActivity(new Intent(context, BlackListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_list);
        initView();

        adapter = new RecyclerViewBlackListAdapter(getPhoneList());
        adapter.setListener(new RecyclerViewBlackListAdapter.OnItemClickListener() {
            @Override
            public void onClickItem(String phone) {

            }

            @Override
            public void onClickMinus(int phone) {
            }

            @Override
            public void onClickDelete(int phone) {
                list.remove(phone);
                adapter.setPhoneNumberList(list);
            }
        });

        rvBlackList.setHasFixedSize(true);
        rvBlackList.setLayoutManager(new LinearLayoutManager(this));
        rvBlackList.setAdapter(adapter);

        tvReady.setOnClickListener(v -> finish());
    }

    @Override
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (adapter != null) {
            adapter.saveStates(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (adapter != null) {
            adapter.restoreStates(savedInstanceState);
        }
    }

    private List<String> getPhoneList() {
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        list.add("+99890 123 45 67");
        return list;
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(v -> onBackPressed());
        tvReady = findViewById(R.id.tv_ready);
        rvBlackList = findViewById(R.id.recycler_black_list);
    }
}