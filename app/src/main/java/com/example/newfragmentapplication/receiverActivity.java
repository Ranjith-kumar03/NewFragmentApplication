package com.example.newfragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class receiverActivity extends AppCompatActivity implements SenderActivity.clickfromActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        SenderActivity activity=new SenderActivity(receiverActivity.this);
    }

    @Override
    public void buttonClickActivity() {
        Toast.makeText(this, "Iam clicked by sender", Toast.LENGTH_SHORT).show();
    }
}
