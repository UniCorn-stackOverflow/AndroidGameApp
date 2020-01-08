package com.example.androidgameapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class lvl1 extends AppCompatActivity {

    ImageView player;
    Character enemy1;
    public final static String isCharacter1 = "yes";
    public String isPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        loadPlayer();
        //enemy1.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
        //enemy1.draw();

    }

    protected void loadPlayer()
    {
        isPlayer1 = getIntent().getExtras().getString(isCharacter1);
        //Test
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Is Character 1?");

        if(isPlayer1.equals("yes"))
        {
            msg.setMessage(isPlayer1);
            msg.setCancelable(true);
            AlertDialog msgDialog = msg.create();
            msgDialog.show();
        }
        else
        {
            msg.setMessage("no");
            msg.setCancelable(true);
            AlertDialog msgDialog = msg.create();
            msgDialog.show();
        }
    }

}