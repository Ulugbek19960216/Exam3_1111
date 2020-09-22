package com.example.exam3_1111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView subTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");

        subTxt = findViewById(R.id.subTxt);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(Intent.EXTRA_TEXT);
        subTxt.setText(msg);
    }

    public void closeBtnClick(View v) {
        finish();
    }
}