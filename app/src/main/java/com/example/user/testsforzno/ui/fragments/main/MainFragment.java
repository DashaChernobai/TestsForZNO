package com.example.user.testsforzno.ui.fragments.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.testsforzno.R;
import com.example.user.testsforzno.ui.base.BaseFragment;
import com.example.user.testsforzno.ui.fragments.QuestionsFragment;
import com.example.user.testsforzno.ui.fragments.StatisticsFragment;

public class MainFragment extends BaseFragment {

    private MainViewModel mViewModel;
    private Button start;
    private Button btnStatisics;
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        start = view.findViewById(R.id.btnStart);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment1(new QuestionsFragment());
            }
        });
        btnStatisics = view.findViewById(R.id.btnStatisics);
        btnStatisics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment2(new StatisticsFragment());
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public String getName() {
        return "Main";
    }
}
