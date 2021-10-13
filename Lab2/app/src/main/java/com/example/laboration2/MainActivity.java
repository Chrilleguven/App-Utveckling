package com.example.laboration2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });


        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

    }

    public void hide(View view){
        TextView textView = (TextView)findViewById(R.id.textView);

        if(textView.getVisibility() == View.VISIBLE){
            textView.setVisibility(View.INVISIBLE);
        }else{
            textView.setVisibility(View.VISIBLE);
        }
    }

    public void openActivity2 (){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void openActivity3 (){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}