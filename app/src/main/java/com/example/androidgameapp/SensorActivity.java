package com.example.androidgameapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorActivity extends Activity implements SensorEventListener {

    public SensorManager getSensor() {
        return sensor;
    }

    private SensorManager sensor;
    private Sensor accelerometer;
    private PlayableChar player;
    public SensorActivity(){
        sensor = (SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer = sensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        player = new PlayableChar();
    }

    protected void onResume(){
        super.onResume();
        sensor.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause(){
        super.onPause();
        sensor.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        player.move(event,getSensor());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
