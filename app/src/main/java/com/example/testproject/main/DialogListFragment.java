package com.example.testproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class DialogListFragment extends Fragment {

    public DialogListFragment() {
        // Required empty public constructor
    }

    public static DialogListFragment newInstance() {
        return new DialogListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_dialog_list, container, false);

        return view;
    }
}