package com.example.exam3_1111;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_PHOTO =1;
    EditText inputTxt;
    EditText inputUrl;
    EditText inputShareTxt;
    ImageButton photoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTxt = findViewById(R.id.inputTxt);
        inputUrl = findViewById(R.id.inputURL);
        inputShareTxt = findViewById(R.id.inputShareTxt);
        photoBtn =findViewById(R.id.photoBtn);
    }

    public void callSubBtnClick(View v) {
        Intent intent = new Intent(this,SubActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, inputTxt.getText().toString());
        startActivity(intent);
    }

    public void callWebBtnClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("https://"+inputUrl.getText());
        intent.setData(uri);
        startActivity(intent);
    }

    public void callShareBtnClick(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT, inputShareTxt.getText().toString());

        Intent chooser = Intent.createChooser(intent, "Share Text");
        startActivity(chooser);
    }
    public void callCamaraBtnClick(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_PHOTO && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            photoBtn.setImageBitmap(bitmap);
        }

    }
}