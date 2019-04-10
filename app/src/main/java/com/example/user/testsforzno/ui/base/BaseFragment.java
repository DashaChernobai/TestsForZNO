package com.example.user.testsforzno.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.example.user.testsforzno.R;
import com.example.user.testsforzno.ui.fragments.Questions;
import com.example.user.testsforzno.ui.fragments.QuestionsFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public abstract class BaseFragment extends Fragment implements IFragment {
    public ArrayList<Questions> list;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = new ArrayList<>();
        dbInit();
    }

    public FirebaseFirestore db;

    public void setFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.include, fragment, fragment.getName()).commit();
    }

    public void getCollection() {
        db.collection("Questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Questions questions = new Questions();
                                questions.setVariants((String[]) document.getData().get("variants"));
                                questions.setQuestion(document.getData().get("question").toString());
                                questions.setAnswer((int) document.getData().get("answer"));
                                Log.i("Firestore", document.getId() + " => ");
                            }
                        } else {
                            Log.w("Firestore", "Error getting documents.", task.getException());
                        }
                    }
                });
    }


    private void dbInit() {
        db = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        db.setFirestoreSettings(settings);
    }

}