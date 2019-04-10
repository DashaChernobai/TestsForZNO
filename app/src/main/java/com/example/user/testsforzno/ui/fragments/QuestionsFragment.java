package com.example.user.testsforzno.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.testsforzno.R;
import com.example.user.testsforzno.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionsFragment extends BaseFragment {

    private QuestionsViewModel mViewModel;
    TextView text;


    public static QuestionsFragment newInstance() {
        return new QuestionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.questions_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QuestionsViewModel.class);
        getCollection();
        text =view.findViewById(R.id.text);
        text.setText(list.get(1).getQuestion());


    }


    @Override
    public String getName() {
        return "Questions";
    }





}
