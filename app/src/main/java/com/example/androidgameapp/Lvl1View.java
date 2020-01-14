package com.example.androidgameapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class Lvl1View extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mainThread;
    private EnemyCharacter enemy;
    private PlayableChar player;

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
        enemy = new EnemyCharacter();
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
        enemy.update(player.getX());
        player.update();

    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if(canvas!=null){
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.map1),0,0,null);

        }
        enemy.draw(canvas);
        player.draw(canvas);

    }
    public void collisionDetection(){
        int pX = player.getX();
        int eX = enemy.getX();
        int vel = player.getxVelocity();

        if((pX + vel) == eX)
        {
            player.setX(pX);
            enemy.setX(eX);
        }
    }

}
