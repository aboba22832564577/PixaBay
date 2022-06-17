package com.geektech.pixabay.network.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.pixabay.network.adapter.ImageStorage;

import java.util.List;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<List<Hit>> hit;


    public MainViewModel() {
        hit = new MutableLiveData<>();
    }

    public void getList(String title, int perPage, int page) {
        ImageStorage.getList(title, perPage, page, new ImageStorage.Result() {
            @Override
            public void onSuccess(List<Hit> list) {
                hit.setValue(list);
            }

            @Override
            public void onError(String msg) {
                hit.setValue(null);
            }
        });
    }

    public MutableLiveData<List<Hit>> getHit() {
        return hit;
    }
}
