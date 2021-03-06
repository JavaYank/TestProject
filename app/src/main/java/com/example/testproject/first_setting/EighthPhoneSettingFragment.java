package com.example.testproject.first_setting;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.first_setting.adapter.RecyclerPhoneOperatorAdapter;

import java.util.ArrayList;

public class EighthPhoneSettingFragment extends Fragment {

    private RecyclerView recyclerView;
    private Button btnNext;
    private int selectedItem = -1;

    public EighthPhoneSettingFragment() {
        // Required empty public constructor
    }

    public static EighthPhoneSettingFragment newInstance() {
        return new EighthPhoneSettingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_eighth_phone_setting, container, false);
        btnNext = view.findViewById(R.id.btn_next);
        recyclerView = view.findViewById(R.id.recycler_phone_operators);

        RecyclerPhoneOperatorAdapter adapter = new RecyclerPhoneOperatorAdapter(new ArrayList<>());
        adapter.setListener(position -> {
            selectedItem = position;
            checkValidation();
        });

        btnNext.setOnClickListener(v -> ((FirstSettingActivity) getActivity()).addFragment(NinthInstructionFragment.newInstance()));

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        checkValidation();
        return view;
    }

    private void checkValidation() {
        boolean isValid = false;
        if (selectedItem > -1) {
            isValid = true;
        }

        btnNext.setBackgroundResource(isValid ? R.drawable.button_enabled : R.drawable.button_disabled);
        btnNext.setTextColor(isValid ? Color.parseColor("#404040") : Color.parseColor("#696969"));
        btnNext.setEnabled(isValid);
    }
}