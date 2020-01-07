package com.example.androidgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class lobby extends AppCompatActivity {

    private ImageButton imgBtnP1;
    private ImageButton imgBtnP2;
    private Button btnChoose;
    private ImageView imgVStatPrev1;
    private ImageView ImgVStatPrev2;
    private boolean isPlayer1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        imgBtnP1 = (ImageButton)findViewById(R.id.imageButtonPlayer1);
        imgBtnP2 = (ImageButton)findViewById(R.id.imageButtonPlayer2);
        btnChoose = (Button) findViewById(R.id.buttonChoose);
        imgVStatPrev1 = (ImageView) findViewById(R.id.imageViewStatPreview1);
        ImgVStatPrev2 = (ImageView) findViewById(R.id.imageViewStatPreview2);
        btnChoose.setEnabled(false);
    }

    public void onClickP1(View view)
    {
        isPlayer1 = true;
        imgVStatPrev1.setVisibility(View.VISIBLE);
        ImgVStatPrev2.setVisibility(View.INVISIBLE);
        btnChoose.setEnabled(true);
    }
    public void onClickP2(View view)
    {
        isPlayer1 = false;
        ImgVStatPrev2.setVisibility(View.VISIBLE);
        imgVStatPrev1.setVisibility(View.INVISIBLE);
        btnChoose.setEnabled(true);
    }
    public void onClickChoose(View view)
    {
        Intent myIntent;
        myIntent = new Intent(lobby.this,lvl1.class);
        startActivity(myIntent);

    }
}
