package com.example.testproject.first_setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.testproject.R;

public class NinthInstructionFragment extends Fragment {

    private Button btnNext;

    public NinthInstructionFragment() {
        // Required empty public constructor
    }

    public static NinthInstructionFragment newInstance() {
        return new NinthInstructionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_ninth_instruction, container, false);

        return view;
    }
}