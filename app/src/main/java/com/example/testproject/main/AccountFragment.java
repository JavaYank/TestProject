package com.example.testproject.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.main.adapter.RecyclerAccountMenuAdapter;
import com.example.testproject.profile.ProfileActivity;
import com.example.testproject.subscribtion.SubscriptionActivity;
import com.example.testproject.utils.objects.AccountItemMenu;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {

    private TextView tvName;
    private TextView tvPhone;
    private RecyclerView rvAccount;
    private BottomSheetDialog bottomSheetDialog;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_account, container, false);
        tvName = view.findViewById(R.id.tv_name);
        tvPhone = view.findViewById(R.id.tv_phone);
        rvAccount = view.findViewById(R.id.rv_account);

        rvAccount.setHasFixedSize(true);
        rvAccount.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAccountMenuAdapter adapter = new RecyclerAccountMenuAdapter(createMenuList());
        rvAccount.setAdapter(adapter);

        adapter.setListener(itemMenu -> {
            switch (itemMenu.getId()) {
                case 1:
                    ProfileActivity.start(getActivity());
                    break;
                case 2:
                    SubscriptionActivity.start(getActivity());
                    break;
                case 3:
                    openBottomSheet();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 8:

                    break;
                case 9:

                    break;
            }
        });

        return view;
    }

    private void openBottomSheet() {
        View v = getLayoutInflater().inflate(R.layout.dialog_subs_3_month, null);

        bottomSheetDialog = new BottomSheetDialog(getActivity(), R.style.BottomSheetDialog);
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.setDismissWithAnimation(true);
        bottomSheetDialog.setOnDismissListener(dialog -> {
//            bottomSheetJustClose = true;
//            bottomNavigationView.setSelectedItemId(currentVisibleFragment);
        });
        bottomSheetDialog.show();
    }

    private List<AccountItemMenu> createMenuList() {
        List<AccountItemMenu> list = new ArrayList<>();
        list.add(new AccountItemMenu(0, true, 0, "Аккаунт", ""));
        list.add(new AccountItemMenu(1, false, R.mipmap.ic_user, "Мой профиль", ""));
        list.add(new AccountItemMenu(2, false, R.mipmap.ic_subscription, "Подписка", ""));
        list.add(new AccountItemMenu(3, false, 0, "До 3х месяцев Бесплатно", ""));

        list.add(new AccountItemMenu(4, true, 0, "Поддержка", ""));
        list.add(new AccountItemMenu(5, false, R.mipmap.ic_faq, "Обратная связь", ""));
        list.add(new AccountItemMenu(6, false, R.mipmap.ic_faq, "FAQ", ""));


        list.add(new AccountItemMenu(7, true, 0, "Приватность", ""));
        list.add(new AccountItemMenu(8, false, 0, "Условия использования", ""));
        list.add(new AccountItemMenu(9, false, 0, "Политика приватности", ""));
        return list;
    }
}