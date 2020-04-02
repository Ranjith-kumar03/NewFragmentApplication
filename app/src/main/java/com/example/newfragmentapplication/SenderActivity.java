package com.example.newfragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SenderActivity extends AppCompatActivity {

    Button buttonClick;
    clickfromActivity listener;
    interface clickfromActivity{
        void buttonClickActivity();
    }
    public SenderActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        buttonClick=findViewById(R.id.buttonClick);
       
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.buttonClickActivity();
            }
        });
    }


}
