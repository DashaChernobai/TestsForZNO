package com.example.user.testsforzno.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.testsforzno.R;

import static com.example.user.testsforzno.ui.fragments.QuestionsFragment.*;

public class StatisticsFragment extends Fragment {

TextView justtext;
TextView number;
int sum1;
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
        return new StatisticsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        justtext.findViewById(R.id.justtext);
        number.findViewById(R.id.number);
        sum1 = QuestionsFragment.sum;
        number.getText();                              //!!!!!!!


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }


}
