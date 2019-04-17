package com.example.user.testsforzno.ui.fragments;

import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Questions implements Serializable {
    @PropertyName("answer")
    private int answer;
    @PropertyName("question")
    private String question;
    @PropertyName("variants")
    private ArrayList<String> variants;

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<String> variants) {
        this.variants = variants;
    }
}
