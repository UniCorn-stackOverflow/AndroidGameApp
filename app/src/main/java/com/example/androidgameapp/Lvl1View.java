package com.example.androidgameapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

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
        //createEnemies();
        enemy = new EnemyCharacter();
        enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));

        mainThread.setRunning(true);
        mainThread.start();
    }
    public void createEnemies()
    {
        enemies = new EnemyCharacter[5];
        for(int i = 0; i<5 ; i++)
        {
            enemy = new EnemyCharacter();
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
            enemies[i] =  enemy;
        }
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
       //enemy.update(player.getX());
        /*for(int i = 0; i <5 ;i++)
        {
            enemies[i].update(player.getX());
        }*/
        //player.update();
        updateEnemy(enemy, player);

    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if(canvas!=null){
            canvas.drawBitmap(resizedMap,0,0,null);
        }
        enemy.draw(canvas);
        /*for(int i = 0; i <5 ;i++)
        {
            enemies[i].draw(canvas);
        }*/

        player.draw(canvas);

    }
    public void updateEnemy(EnemyCharacter enemy, PlayableChar player) {

        int xVelocity = enemy.getxVelocity();
        collision = false;
        if((enemy.getX() + xVelocity) == player.getX()  || enemy.getX() == player.getX() || enemy.getX() + enemy.getImage().getWidth()/2 == player.getX() || enemy.getX() - enemy.getImage().getWidth()/2 == player.getX() || collision == true)
        {
            enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.setst));
            enemy.setX(enemy.getX() - enemy.getImage().getWidth());
            player.setX(player.getX() + enemy.getxVelocity());
            collision = true;
        }
        else {

            if(enemy.getX() <= player.getX())
            {
                enemy.addX(xVelocity);
                if ((enemy.getX() > screenWidth - enemy.getImage().getWidth()) || (enemy.getX() < 0)) {
                    xVelocity = xVelocity*-1;
                    enemy.setxVelocity(xVelocity);
                }
            }else
            {
                enemy.addX((xVelocity)*-1);
            }

        }


    }


}
