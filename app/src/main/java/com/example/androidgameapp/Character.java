package com.example.androidgameapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

class Character {
    private double health;
    private Bitmap image;

    public Character(){}
    public void setHealth(double health)
    {
        this.health = health;
    }
    public double getHealth()
    {
        return health;
    }
    public void setImage(Bitmap bmp)
    {
        image = bmp;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,50,50,null);
    }

}
