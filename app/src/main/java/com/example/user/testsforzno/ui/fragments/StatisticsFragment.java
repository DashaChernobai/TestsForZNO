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
import com.google.android.gms.plus.PlusOneButton;


public class StatisticsFragment extends Fragment {
    TextView vsevoresheno;
    public static StatisticsFragment newInstance(String param1, String param2) {

        return new StatisticsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);









    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_statistics, container, false);


        vsevoresheno.findViewById(R.id.vsevoresheno);

        return view;
    }

    
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
