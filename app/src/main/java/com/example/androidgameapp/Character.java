package com.example.androidgameapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;

abstract class Character  {
    private double health;
    private Bitmap image;
    private int damage;
    private int x;
    private int y = (Resources.getSystem().getDisplayMetrics().heightPixels)-320;
    private int xVelocity = 5;
    //private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    public Character(){



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
    public int getX(){return x;}
    public int getY(){return y;}
    public void setY(int y) {this.y = y; }
    public void setxVelocity(int xVelocity){ this.xVelocity = xVelocity;}
    public int getxVelocity(){return xVelocity;}
    public Bitmap getImage(){return image;}
    public void setImage(Bitmap bmp)
    {
        image = bmp;
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image,x,y,null);
    }


    public void addX(int xVelocity)
    {
        x += xVelocity;
    }
    public void recieveDamage(int damage)
    {
        health -= damage;
    }
}
