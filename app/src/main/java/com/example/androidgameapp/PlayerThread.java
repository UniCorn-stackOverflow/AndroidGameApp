package com.example.androidgameapp;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PlayerThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private Lvl1View lvl1View;
    private boolean running;
    public static Canvas canvas;

    public PlayerThread(SurfaceHolder surfaceHolder, Lvl1View lvl1View)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.lvl1View = lvl1View;

    }

    @Override
    public void run() {
        while (running)
        {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.lvl1View.update();
                    this.lvl1View.draw(canvas);
                }
            } catch (Exception e) {}
            finally{
                if(canvas != null)
                {
                    try
                    {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }catch(Exception e){e.printStackTrace();}
                }

            }
        }
    }
    public void setRunning(boolean isRunning) { running = isRunning;}

}
