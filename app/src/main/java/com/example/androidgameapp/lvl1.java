package com.example.androidgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class lvl1 extends AppCompatActivity {

    Intent prIntent;
    ImageView player;
    Character enemy1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        prIntent = getIntent();
        //enemy1.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
        //enemy1.draw();

    }

}
