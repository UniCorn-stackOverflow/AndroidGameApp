package com.example.androidgameapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

class Character {
    private double health;
    private Bitmap image;
    private int damage;
    private int x;
    private int y = (Resources.getSystem().getDisplayMetrics().heightPixels) / 2;
    //private int yVelocity;
    private int xVelocity = 1;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    //private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public Character(){
        x = (int)(Math.random()*((screenWidth - 0)))+0;
    }
    public void setHealth(double health)
    {
        this.health = health;
    }
    public double getHealth()
    {
        return health;
    }
    public void setDamage(int damage)
    {
        this.damage = damage;
    }
    public int getDamage()
    {
        return damage;
    }
    public void setX(int x){ this.x = x;}
    public void setxVelocity(int xVelocity){ this.xVelocity = xVelocity;}
    public void setImage(Bitmap bmp)
    {
        image = bmp;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
    }
    public void update(){
        x += xVelocity;
        //y += yVelocity;
        if ((x > screenWidth - image.getWidth()) || (x < 0)) {
            xVelocity = xVelocity*-1;
        }
    }
}
