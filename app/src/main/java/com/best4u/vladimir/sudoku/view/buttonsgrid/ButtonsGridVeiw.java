package com.best4u.vladimir.sudoku.view.buttonsgrid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.best4u.vladimir.sudoku.R;

public class ButtonsGridVeiw extends GridView {
    public ButtonsGridVeiw(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButtonsGridViewAdapter gridViewAdapter = new ButtonsGridViewAdapter(context);
        setAdapter(gridViewAdapter);
    }

    class ButtonsGridViewAdapter extends BaseAdapter {
        private Context context;

        public ButtonsGridViewAdapter(Context context)  {
            this.context = context;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            if (v == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                v = inflater.inflate(R.layout.button, parent, false);

                NumberButton btn;
                btn = (NumberButton)v;
                btn.setId(position);

                if (position != 9) {
                    btn.setText(String.valueOf(position + 1));
                    btn.setNumber(position + 1);
                } else {
                    btn.setText("DEL");
                    btn.setNumber(0);
                }
                return btn;
            }
            return v;
        }
    }

}
