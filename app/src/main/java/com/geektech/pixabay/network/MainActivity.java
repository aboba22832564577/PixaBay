package com.geektech.pixabay.network;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.geektech.pixabay.databinding.ActivityMainBinding;
import com.geektech.pixabay.network.adapter.ImageAdapter;
import com.geektech.pixabay.network.model.MainViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final ImageAdapter adapter = new ImageAdapter();
    int perPage = 10;
    int page = 1;

    private MainViewModel mainViewModel;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initModel();
        initAdapter();
        initSwipe();
        observeHit();
        initClickers();
    }

    private void observeHit() {
        mainViewModel.getHit().observe(this, adapter::setList);
    }

    private void initModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initAdapter() {
        binding.itemRv.setAdapter(adapter);
    }

    private void initSwipe() {
        binding.srlContainer.setOnRefreshListener(() -> {
            page++;
            init(binding.edSearch.getText().toString().trim(), perPage, page);
            binding.srlContainer.setRefreshing(false);
        });
    }


    private void initClickers() {
        binding.apply.setOnClickListener(v -> {
            String search = binding.edSearch.getText().toString().trim();
            init(search, perPage, page);
        });
        binding.plusPage.setOnClickListener(v -> {
            ++page;
            init(binding.edSearch.getText().toString().trim(), perPage, page);
        });
    }

    private void init(String search, int perPage, int page) {
        mainViewModel.getList(search, perPage, page);
    }
}