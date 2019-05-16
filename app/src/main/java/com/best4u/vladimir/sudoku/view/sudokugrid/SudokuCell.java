package com.best4u.vladimir.sudoku.view.sudokugrid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SudokuCell extends BaseSudokuCell {

    private Paint mPaint;

    public SudokuCell(Context context){
        super(context);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) { //переопределяем метод для рисования кастомного вида
        super.onDraw(canvas);
        drawNumber(canvas); //рисуем фифру 1 - 9
        drawLines(canvas);  //рисуем линии
    }

    private void drawNumber(Canvas canvas){
        mPaint.setColor(Color.BLACK); //цвет текста
        mPaint.setTextSize(60); //размер текста (ед. ?)
        mPaint.setStyle(Paint.Style.FILL);
        Rect bounds = new Rect(); //новый прямоугольник
        //Среди методов измерения также есть метод getTextBounds, который позволит получить вам прямоугольник, в который заключен текст.
        mPaint.getTextBounds(String.valueOf(getValue()), 0, String.valueOf(getValue()).length(), bounds); //возвращает прямоугольник, ограничивающий текст
        if (getValue() != 0) {
            canvas.drawText(String.valueOf(getValue()), (getWidth() - bounds.width()) / 2, (getHeight() + bounds.height()) / 2, mPaint);
        }
    }

    private void drawLines(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE );
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
