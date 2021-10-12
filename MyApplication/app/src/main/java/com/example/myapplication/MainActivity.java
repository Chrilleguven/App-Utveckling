package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFlipper viewFlipper = (ViewFlipper)findViewById(R.id.flipperid);

        viewFlipper.startFlipping();


        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause(){

        super.onPause();

        Log.i(TAG, "onPause");

    }

    @Override
    protected void onStop(){

        super.onStop();

        Log.i(TAG, "onStop");

    }

    @Override
    protected void onDestroy(){

        super.onDestroy();

        Log.i(TAG, "onDestroy");

    }



    public void openActivity2 (){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}