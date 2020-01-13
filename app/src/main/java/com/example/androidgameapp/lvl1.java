package com.example.androidgameapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.File;

public class lvl1 extends Activity {

    PlayableChar playableChar;
    public final static String isCharacter1 = "yes";
    public String isPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        loadPlayer();
        playableChar.setX(Resources.getSystem().getDisplayMetrics().widthPixels/2);
        playableChar.setxVelocity(10);
        setContentView(new Lvl1View(this,playableChar));
    }

    protected void loadPlayer()
    {
        isPlayer1 = getIntent().getExtras().getString(isCharacter1);


        if(isPlayer1.equals("yes"))
        {
            //champ.png
            //300 190 1.2
            playableChar = new PlayableChar();
            playableChar.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.champ));
            playableChar.setHealth(300);
            playableChar.setDamage(190);
            playableChar.setAttackspeed(1.2);
        }
        else
        {
            //blankplayer.png
            //500 90 0.5
            playableChar = new PlayableChar();
            playableChar.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.blankplayer));
            playableChar.setHealth(500);
            playableChar.setDamage(90);
            playableChar.setAttackspeed(0.5);

        }
    }

}