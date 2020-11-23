package com.example.app.ui.league;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LeagueViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LeagueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is league fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}