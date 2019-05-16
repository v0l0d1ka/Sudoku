package com.best4u.vladimir.sudoku.view.sudokugrid;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.best4u.vladimir.sudoku.GameEngine;
import com.best4u.vladimir.sudoku.R;

public class SudokuGridView extends GridView {
    private Context context;

    public SudokuGridView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        SudokuGridViewAdapter gridViewAdapter = new SudokuGridViewAdapter(context);
        setAdapter(gridViewAdapter);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int x = position % 9;
                int y = position / 9;
                GameEngine.getInstance().setSelectedPosX(x, y);
                Toast.makeText(context, "Selected item x: " + x + " y: " + y, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public class SudokuGridViewAdapter extends BaseAdapter {

        private Context context;
        public SudokuGridViewAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return 81;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameEngine.getInstance().getGrid().getItem(position);
        }
    }
}
