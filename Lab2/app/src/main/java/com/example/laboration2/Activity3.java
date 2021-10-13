package com.example.laboration2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.laboration2.databinding.Activity3Binding;
import com.example.laboration2.databinding.ActivityMainBinding;

public class Activity3 extends AppCompatActivity {

    Activity3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] image = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic1, R.drawable.pic1};

        GridAdapter gridAdapter = new GridAdapter(Activity3.this, image);

        binding.gridView.setAdapter(gridAdapter);

    }
}