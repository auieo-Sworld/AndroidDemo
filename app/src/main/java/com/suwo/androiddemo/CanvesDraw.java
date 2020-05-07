package com.suwo.androiddemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CanvesDraw extends View {
    public CanvesDraw(Context context) {
        super(context);
    }

    public CanvesDraw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvesDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CanvesDraw(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // drawLine(canvas);
      // drawRect(canvas);
//        drawArc(canvas);
  //     drawBitmap(canvas);
     //   translate(canvas);
//        rotate(canvas);
//        scale(canvas);
       skew(canvas);
//        clip(canvas);
//       saveLayer(canvas);
    }

    private void saveLayer(Canvas canvas) {
        Paint paint = new Paint();
        canvas.drawColor(Color.WHITE);
        canvas.translate(10,10);
        paint.setColor(Color.RED);
        canvas.drawCircle(75,75,75,paint);

        canvas.saveLayerAlpha(0,0,200,0x88,0);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(125,125,75,paint);
        canvas.restore();
    }

    private void clip(Canvas canvas) {
        Rect rect = new Rect(0,0,200,200);
        int k = canvas.save();
        canvas.clipRect(rect);
        canvas.drawColor(Color.BLUE);
        canvas.restoreToCount(k+1);
        canvas.drawColor(Color.RED);
    }

    private void skew(Canvas canvas) {
        Paint paint_green = new Paint();
        paint_green.setColor(Color.GREEN);
        paint_green.setStyle(Paint.Style.STROKE);

        Paint paint_red = new Paint();
        paint_red.setColor(Color.RED);
        paint_red.setStyle(Paint.Style.STROKE);

        Rect rect1 = new Rect(0,0,100,100);
        canvas.drawRect(rect1,paint_green);
        canvas.skew(1,0.1f);  //x轴倾斜45度，Y轴不变
        canvas.drawRect(rect1,paint_red);
    }

    private void scale(Canvas canvas) {
        Paint mPaint = new Paint();
        Rect rect = new Rect(0,0,400,400);

        mPaint.setColor(Color.RED);
        canvas.drawRect(rect,mPaint);

        canvas.scale(0.1f,0.1f,480,80);

        Rect rect1 = new Rect(400,0,480,80);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(rect1,mPaint);
    }

    private void rotate(Canvas canvas) {
        canvas.drawColor(Color.GRAY);

        Paint mPaint = new Paint();
        Rect rect = new Rect(300,0,400,100);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rect,mPaint);

        canvas.rotate(5,300,0);
        mPaint.setColor(Color.RED);
        canvas.drawRect(rect,mPaint);
    }

    private void translate(Canvas canvas) {
        Paint mPaint = new Paint();
        Rect rect = new Rect(0,0,100,100);

        mPaint.setColor(Color.BLUE);
        canvas.translate(500,500);

        mPaint.setColor(Color.RED);
        canvas.drawRect(rect,mPaint);
    }

    private void drawBitmap(Canvas canvas) {
        Bitmap mBitMap = BitmapFactory.decodeResource(getResources(),R.drawable.tumanman);
        Paint paint = new Paint();

        canvas.drawBitmap(mBitMap,0,0,paint);

        Matrix matrix = new Matrix();
        matrix.setRotate(60,mBitMap.getWidth()/2,mBitMap.getHeight());
        canvas.drawBitmap(mBitMap,matrix,paint);

        Matrix matrix2 = new Matrix();
        matrix.setRotate(120,mBitMap.getWidth()/2,mBitMap.getHeight());
        canvas.drawBitmap(mBitMap,matrix2,paint);

        Matrix matrix3 = new Matrix();
        matrix3.setRotate(180,mBitMap.getWidth()/2,mBitMap.getHeight());
        canvas.drawBitmap(mBitMap,matrix3,paint);

        Paint pointPaint = new Paint();
        pointPaint.setColor(Color.RED);
        pointPaint.setStrokeWidth((float) 20.0);
        canvas.drawPoint(mBitMap.getWidth()/2,mBitMap.getHeight(),pointPaint);
    }

    private void drawArc(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        RectF ovel1 = new RectF(20.0f,20.0f,180.0f,220.0f);
        canvas.drawArc(ovel1,0,45,true,paint);

        RectF ovel2 = new RectF(120.0f,20.0f,280.0f,220.0f);
        canvas.drawArc(ovel2,0,90,true,paint);

        RectF ovel3 = new RectF(300.0f,20.0f,460.0f,220.0f);
        canvas.drawArc(ovel1,90,135,true,paint);

        RectF ovel4 = new RectF(480.0f,20.0f,640.0f,220.0f);
        canvas.drawArc(ovel2,90,135,false,paint);
    }

    private void drawRect(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(new Rect(10,10,600,500),paint);

        paint.setColor(Color.BLUE);
        canvas.drawRect(new Rect(20,700,900,900),paint);
    }

    private void drawLine(Canvas canvas) {
        int x=0,y=0;
        int height = 100;
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        canvas.drawLine(x,y+height-1,x+canvas.getWidth(),y+height-1,paint);

        paint.setColor(Color.BLACK);
        canvas.drawPoint(200,200,paint);
    }
}
