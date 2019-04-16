package com.example.user.testsforzno.ui.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class QuestionsViewModel extends ViewModel {
    public MutableLiveData<List<Questions>> listMutableLiveData =new MutableLiveData<>();
    public void setList(List<Questions> list){
        listMutableLiveData.postValue(list);
    }

}
