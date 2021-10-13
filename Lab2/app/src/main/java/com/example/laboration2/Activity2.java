package com.example.laboration2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Activity2 extends AppCompatActivity {
    private static final String activity2 = "Activity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.desert);

    }
}