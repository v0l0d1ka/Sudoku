package com.best4u.vladimir.sudoku.view.sudokugrid;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BaseSudokuCell extends View {

    private boolean modifiable = true; //можно или нет, модифицировать клетку

    private int value;
    //конструктор
    public BaseSudokuCell(Context context) {
        super(context); //вызывает вызывает родительский конструктор без аргументов

    }

    //Теперь нам необходимо переопределить процедуру настройки размеров компонента — onMeasure.
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // 300, 50
    }

    public void setNotModifiable() {
        modifiable = false;
    }  //сеттер запрещает модифицировать клетку

    public void setInitValue(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        if (modifiable) {  //можно изменять значение клетки только если "модифицируемо"
            this.value = value;
        }
        invalidate(); //необходимо самим постоянно вызывать перерисовку экрана и он в свою очередь вызовет onDraw.

    }

    public int getValue() {
        return value;
    }

}
