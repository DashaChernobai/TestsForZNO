package com.example.user.testsforzno.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.user.testsforzno.R;
import com.example.user.testsforzno.ui.fragments.QuestionsFragment;
import com.example.user.testsforzno.ui.fragments.StatisticsFragment;

public abstract class BaseFragment extends Fragment implements IFragment {


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }



    public void setFragment1(QuestionsFragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.include, fragment, fragment.getName()).commit();
    }
    public void setFragment2(StatisticsFragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.include, fragment, fragment.getName()).commit();
    }


}