package com.example.androidgameapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import androidx.appcompat.app.AlertDialog;

public class Lvl1View extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mainThread;
    private EnemyCharacter enemy;
    private EnemyCharacter[] enemies;
    private PlayableChar player;
    private Bitmap map1;
    private Bitmap resizedMap;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    boolean collision = false;




    private SensorManager sensor;

    public Lvl1View(Context context, PlayableChar player){
        super(context);
        this.player = player;
        getHolder().addCallback(this);
        mainThread = new MainThread(getHolder(), this);
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        map1 = BitmapFactory.decodeResource(getResources(),R.drawable.map1);
        resizedMap = Bitmap.createScaledBitmap(map1,(Resources.getSystem().getDisplayMetrics().widthPixels),(Resources.getSystem().getDisplayMetrics().heightPixels),true);
        enemy = new EnemyCharacter();
        enemy.setX((int) (Math.random() * screenWidth + 1));
        enemy.setDamage(20);
        enemy.setY((Resources.getSystem().getDisplayMetrics().heightPixels)-320);
        enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
        mainThread.setRunning(true);
        mainThread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            { mainThread.setRunning(false);
                mainThread.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public void update(){

        if(player.getHealth() <= 0)
        {
            System.exit(0);
        }
        else
        {
            updateEnemy(enemy, player);
            //updatePlayer(player, enemy);
        }

    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if(canvas!=null){
            canvas.drawBitmap(resizedMap,0,0,null);
        }
        enemy.draw(canvas);

        player.draw(canvas);

    }


     protected void updatePlayer(PlayableChar player,EnemyCharacter enemy){
        int xE = enemy.getX();

        int xVelocity = player.getxVelocity();
        if((player.getX() + player.getxVelocity()) == xE)
        {
            player.setX(player.getX());
        }
        else{
            player.addX(player.getxVelocity());
        }

        if ((player.getX() > screenWidth - player.getImage().getWidth() || (player.getX()) < 0)) {
            xVelocity = xVelocity*-1;
            player.setxVelocity(xVelocity);
        }
    }
    /*public void updateEnemy(EnemyCharacter enemy, PlayableChar player ){
        richtige update enemy
        int xVelocity = enemy.getxVelocity();
        collision = false;
        if((enemy.getX() + xVelocity) == player.getX()  || enemy.getX() == player.getX() || enemy.getX() + enemy.getImage().getWidth()/2 == player.getX() || enemy.getX() - enemy.getImage().getWidth()/2 == player.getX() || collision == true)
        {
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.setst));
            player.recieveDamage(enemy.getDamage());
            enemy.addX(enemy.getxVelocity()*-1);
            player.addX(enemy.getxVelocity());
            collision = true;
        }
        else {
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
            if(enemy.getX() <= player.getX())
            {
                enemy.addX(xVelocity);
                if ((enemy.getX() > screenWidth - enemy.getImage().getWidth()) || (enemy.getX() < 0)) {
                    xVelocity = xVelocity*-1;
                    enemy.setxVelocity(xVelocity);
                }
            }else
            {
                enemy.addX(xVelocity*-1);
            }

        }
    }*/
    public void updateEnemy(EnemyCharacter enemy, PlayableChar player ){

        int xVelocity = enemy.getxVelocity();
        collision = false;
       if((enemy.getX() + enemy.getxVelocity()) == player.getX()  || enemy.getX() == player.getX() || enemy.getX() + enemy.getImage().getWidth()/2 == player.getX() || enemy.getX() - enemy.getImage().getWidth() == player.getX() || collision == true )
        //if((enemy.getX() + enemy.getxVelocity() == player.getX()))nope
        //if(enemy.getX() == player.getX()) nope
        //if(enemy.getX() + enemy.getImage().getWidth()/2 == player.getX())
        //if(enemy.getX() + enemy.getImage().getWidth()/2 == player.getX() + player.getImage().getWidth()/2) nope
        //if(enemy.getX() + enemy.getxVelocity() == player.getX() + player.getImage().getWidth()/2)nope
        {
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.setst));
            player.recieveDamage(enemy.getDamage());
            enemy.addX(enemy.getxVelocity()*-1);
            player.addX(enemy.getxVelocity());
            collision = true;
        }
        else {
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
            if(enemy.getX() <= player.getX())
            {
                enemy.addX(enemy.getxVelocity());
                if ((enemy.getX() > screenWidth - enemy.getImage().getWidth()) || (enemy.getX() < 0)) {
                    enemy.setxVelocity(enemy.getxVelocity()*-1);
                    enemy.setxVelocity(enemy.getxVelocity());
                }
            }else
            {
                enemy.addX(enemy.getxVelocity()*-1);
            }

        }
    }


}
