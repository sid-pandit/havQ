package com.example.havq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaterialButton NewEventBtn;
        NewEventBtn=findViewById(R.id.NewEventBtn);
        MaterialButton PreviousEventBtn;
        PreviousEventBtn=findViewById(R.id.PreviousEventBtn);

        Intent newEvent;
        newEvent= new Intent(MainActivity.this, SecondActivity.class);

        NewEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newEvent);
            }
        });
    }
}