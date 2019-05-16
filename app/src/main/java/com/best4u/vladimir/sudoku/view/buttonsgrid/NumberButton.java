package com.best4u.vladimir.sudoku.view.buttonsgrid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.best4u.vladimir.sudoku.GameEngine;

public class NumberButton extends Button implements View.OnClickListener {
    private int number;
    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void onClick(View v) {
        GameEngine.getInstance().setNumber(number);
    }
}
