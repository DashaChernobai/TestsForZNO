package com.example.user.testsforzno.ui.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user.testsforzno.R;
import com.example.user.testsforzno.ui.base.BaseFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class QuestionsFragment extends BaseFragment {

    private QuestionsViewModel mViewModel;
    TextView text;
    public ArrayList<Questions> list;
    public FirebaseFirestore db;
    CheckBox checkBox0;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button buttonCheckAnswer;
    int answer;
    int a;


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
        text = view.findViewById(R.id.text);
        checkBox0 = view.findViewById(R.id.checkBox0);
        checkBox1 = view.findViewById(R.id.checkBox1);
        checkBox2 = view.findViewById(R.id.checkBox2);
        checkBox3 = view.findViewById(R.id.checkBox3);
       //buttonCheckAnswer = view.findViewById(R.id.buttonCheckAnswer);

        list = new ArrayList<>();
        dbInit();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getCollection();
            }
        }).start();
        mViewModel.listMutableLiveData.observe(this, new Observer<List<Questions>>() {
            @Override
            public void onChanged(@Nullable List<Questions> questions) {
                assert questions != null;
                setUI(questions);
            }
        });
        if (checkBox0.isSelected()) {
            a = 0;
        }
        if (checkBox1.isSelected()) {
            a = 1;
        }
        if (checkBox2.isSelected()) {
            a = 2;
        }
        if (checkBox3.isSelected()) {
            a = 3;
        }

        if (a == answer) {
        } else {
        }
    }

    private void setUI(List<Questions> ui) {

        int i = new Random().nextInt(ui.size());

        text.setText(ui.get(i).getQuestion());
        checkBox0.setText(ui.get(i).getVariants().get(0));
        checkBox1.setText(ui.get(i).getVariants().get(1));
        checkBox2.setText(ui.get(i).getVariants().get(2));
        checkBox3.setText(ui.get(i).getVariants().get(3));


    }

    public void getCollection() {
        try {
            List<Questions> questions = Tasks.await(db.collection("Questions").get()).toObjects(Questions.class);
            mViewModel.setList(questions);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void dbInit() {
        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
    }

    @Override
    public String getName() {
        return "Questions";
    }


}
