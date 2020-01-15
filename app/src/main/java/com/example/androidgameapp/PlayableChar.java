package com.example.androidgameapp;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

class PlayableChar extends Character {

    private double attackspeed;

    public PlayableChar(){}
    public double getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(double attackspeed) {
        this.attackspeed = attackspeed;
    }

    public void angriff()
    {

    }
    public void move(SensorEvent event, SensorManager sensor){
        if(event.values[1] < 2){
            if(getX() > 0){
                setxVelocity(getxVelocity() * -1);
            }

        }
        if(event.values[1] > 2){
            if(getX() < 0){
                setxVelocity(getxVelocity() + -1);
            }
        }
    }




}