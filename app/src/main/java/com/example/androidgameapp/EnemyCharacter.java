package com.example.androidgameapp;

import android.content.res.Resources;
import android.graphics.Bitmap;

class EnemyCharacter extends Character {

    private int x;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    public EnemyCharacter()
    {
        x = (int)(Math.random()*((screenWidth - 0)))+0;
    }


}
