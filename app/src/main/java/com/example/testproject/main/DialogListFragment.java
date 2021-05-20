package com.example.testproject.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.dialog_detail.DialogDetailActivity;
import com.example.testproject.main.adapter.RecyclerViewDialogListAdapter;
import com.example.testproject.utils.objects.MainDialogListItem;

import java.util.ArrayList;
import java.util.List;

public class DialogListFragment extends Fragment {

    private RecyclerView rvDialog;

    public DialogListFragment() {
        // Required empty public constructor
    }

    public static DialogListFragment newInstance() {
        return new DialogListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_dialog_list, container, false);

        rvDialog = view.findViewById(R.id.rv_dialog_list);

        RecyclerViewDialogListAdapter adapter = new RecyclerViewDialogListAdapter(getDialogList());
        adapter.setListener(new RecyclerViewDialogListAdapter.OnItemClickListener() {
            @Override
            public void onClickItem(MainDialogListItem item) {
                DialogDetailActivity.start(getActivity(), item);
            }

            @Override
            public void onClickMinus(MainDialogListItem item) {
                Toast.makeText(getActivity(), "minus", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClickDelete(MainDialogListItem item) {
                Toast.makeText(getActivity(), "delete", Toast.LENGTH_SHORT).show();
            }
        });

        rvDialog.setHasFixedSize(true);
        rvDialog.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDialog.setAdapter(adapter);

        return view;
    }

    private List<MainDialogListItem> getDialogList() {
        List<MainDialogListItem> list = new ArrayList<>();
        list.add(new MainDialogListItem(true, "Сегодня", "", 0, ""));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));

        list.add(new MainDialogListItem(true, "Вчера", "", 0, ""));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_selected, "15:30"));
        list.add(new MainDialogListItem(false, "+7 965 407 00 39", "Привет, увидел ваше объявление на Авито увидел ваше объявление на Авито", R.mipmap.ic_not_selected, "15:30"));

        return list;
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getActivity().getWindow();
        window.setStatusBarColor(Color.parseColor("#FA00D43B"));
    }
}