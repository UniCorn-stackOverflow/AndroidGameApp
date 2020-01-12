package com.example.androidgameapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class Lvl1View extends SurfaceView implements SurfaceHolder.Callback {

    private EnemyThread enemyThread;
    private PlayerThread playerThread;
    private Character enemy;
    private PlayableChar player;

    public Lvl1View(Context context, PlayableChar player){
        super(context);
        this.player = player;
        getHolder().addCallback(this);

        enemyThread = new EnemyThread(getHolder(), this);
        playerThread = new PlayerThread(getHolder(), this);
        setFocusable(true);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        enemy = new Character();
        enemy.setImage(BitmapFactory.decodeResource(getResources(),R.drawable.enemy1));
        enemyThread.setRunning(true);
        enemyThread.start();
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            { enemyThread.setRunning(false);
                enemyThread.join();
                playerThread.setRunning(false);
                playerThread.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public void update(){
        enemy.update();
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


}
