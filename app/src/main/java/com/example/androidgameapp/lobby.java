package com.example.androidgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class lobby extends AppCompatActivity {

    private ImageButton imgBtnP1;
    private ImageButton imgBtnP2;
    private Button btnChoose;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        imgBtnP1 = (ImageButton)findViewById(R.id.imageButtonPlayer1);
        imgBtnP2 = (ImageButton)findViewById(R.id.imageButtonPlayer2);
        btnChoose = (Button) findViewById(R.id.buttonChoose);
    }

    public void onClickP1(View view) {

    }
    public void onClickP2(View view) {

    }
    public void onClickChoose(View view) {

    }
}
