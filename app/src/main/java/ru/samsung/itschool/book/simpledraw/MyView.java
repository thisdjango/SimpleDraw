package ru.samsung.itschool.book.simpledraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import task.Task;

public class MyView extends View {
    int N = 10;
    boolean started = false;
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    boolean switcher = true;
    Paint paint = new Paint();
    long lastTime = System.currentTimeMillis();
    public MyView(Context context) {
        super(context);
        if(!started) {
            for (int i = 0; i < N; ++i) {
                x[i] = (float) (Math.random() * 700);
                y[i] = (float) (Math.random() * 900);
                vx[i] = (float) (Math.random() * 6 - 3);
                vy[i] = (float) (Math.random() * 6 - 3);
            }
            started = true;
        }
    }

    public void changeColors() {
        if (switcher) {
            paint.setColor(color1);
        } else {
            paint.setColor(color2);
        }
        switcher = !switcher;
        // Redraw view
        invalidate();
    }

    public final int color1 = Color.parseColor("#D50000");
    public final int color2= Color.parseColor("#D00000");

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(color1);
        for(int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 60, paint);
        }
        long nowTime = System.currentTimeMillis();
        for(int i = 0; i < N; ++i){
            x[i] += vx[i];
            y[i] += vy[i];
        }
        lastTime = nowTime;
        invalidate();
    }
}
