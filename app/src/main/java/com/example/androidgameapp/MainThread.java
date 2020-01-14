package com.example.androidgameapp;

import android.graphics.Canvas;
import android.graphics.drawable.VectorDrawable;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private Lvl1View lvl1View;
    private boolean running;
    private boolean collision;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, Lvl1View lvl1View)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.lvl1View = lvl1View;

    }
    public void setRunning(Boolean running){this.running = running;};
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
                    lvl1View.collisionDetection();
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


}
