package com.example.testproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.main.adapter.RecyclerAccountMenuAdapter;
import com.example.testproject.setting.BlackListActivity;
import com.example.testproject.setting.CallForwardingActivity;
import com.example.testproject.setting.GreetingSettingActivity;
import com.example.testproject.setting.VoicesActivity;
import com.example.testproject.utils.objects.AccountItemMenu;

import java.util.ArrayList;
import java.util.List;

public class SettingFragment extends Fragment {

    private RecyclerView rvAccount;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_setting, container, false);
        rvAccount = view.findViewById(R.id.rv_account);

        if (getActivity() != null) {

            rvAccount.setHasFixedSize(true);
            rvAccount.setLayoutManager(new LinearLayoutManager(getActivity()));
            RecyclerAccountMenuAdapter adapter = new RecyclerAccountMenuAdapter(createMenuList());
            rvAccount.setAdapter(adapter);


            adapter.setListener(item -> {
                switch (item.getId()) {
                    case 1:
                        VoicesActivity.start(getActivity());
                        break;
                    case 2:
                        GreetingSettingActivity.start(getActivity());
                        break;
                    case 5:
                        CallForwardingActivity.start(getActivity());
                        break;
                    case 6:
                        BlackListActivity.start(getActivity());
                        break;
                }
            });
        }

        return view;
    }

    private List<AccountItemMenu> createMenuList() {
        List<AccountItemMenu> list = new ArrayList<>();
        list.add(new AccountItemMenu(0, true, 0, "Голоса", ""));
        list.add(new AccountItemMenu(1, false, R.mipmap.ic_chat_blue, "Голоса", "Настройте голос вашего цифрового секретаря"));
        list.add(new AccountItemMenu(2, false, 0, "Настройка приветствия", "Настройте текст, с которым ваш секретарь будет приветствовать звонящих."));

        list.add(new AccountItemMenu(4, true, 0, "Прочее", ""));
        list.add(new AccountItemMenu(5, false, R.mipmap.ic_call_blue, "Переадресация вызовов ", ""));
        list.add(new AccountItemMenu(6, false, R.mipmap.ic_user_black, "Черный список", ""));
        return list;
    }
}