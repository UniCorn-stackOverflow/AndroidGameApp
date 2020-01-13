package com.example.androidgameapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.Display;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class Lvl1View extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mainThread;
    private EnemyCharacter enemy;
    private EnemyCharacter[] enemies;
    private PlayableChar player;
    private Bitmap map1;
    private Bitmap resizedMap;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;


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
        updateEnemy(player.getX(),enemy);
        updatePlayer(player, enemy.getX());
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

     protected void updatePlayer(PlayableChar player, int xE){

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
    public void updateEnemy(int xP, EnemyCharacter enemy){

        int xVelocity = enemy.getxVelocity();
        if((enemy.getX() + enemy.getxVelocity()) == xP)
        {
            enemy.setX(enemy.getX());
        }
        else {
            enemy.addX(enemy.getxVelocity());
        }
            if(enemy.getX() <= xP)
        {
            enemy.addX(enemy.getxVelocity());
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
