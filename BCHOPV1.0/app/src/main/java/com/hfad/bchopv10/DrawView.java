package com.hfad.bchopv10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by РусБЕНЧик on 19.09.2016.
 */
public class DrawView extends View {

    private final Paint  paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap scaledBitmap;
    private Bitmap bmp1;
    private int v =10;
    private int x = 640;
    private int y =10;

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w == 0 || h == 0) return;
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background, options);
        final Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.pachka2, options);
        scaledBitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
        bmp1 = Bitmap.createScaledBitmap(bitmap1, bitmap1.getWidth(), bitmap1.getHeight(), true);
    }



    @Override
    public  boolean onTouchEvent(MotionEvent event) {
        //float evX = event.getX();
        //float evY = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN){
            if (x <= (int) event.getX()){
                x += 50;
            }
            if (x > (int) event.getX()) {
                x -= 50;
            }
            /*if(y<=(int) event.getY())
            {
                y++;
            }
            if(y>(int) event.getY())
            {
                y--;
            }*/

            invalidate();
        }
        return true;
    }
    @Override
    protected  void onDraw(Canvas canvas) {
        canvas.drawBitmap(scaledBitmap, 0, 0, paint);
        //canvas.drawBitmap(bmp1, getWidth() / 2, getHeight() - 100, paint);
        canvas.drawBitmap(bmp1, x, getHeight() - 200, null);
    }
}
