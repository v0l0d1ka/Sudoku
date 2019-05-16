package com.best4u.vladimir.sudoku;

import android.content.Context;

import com.best4u.vladimir.sudoku.view.sudokugrid.GameGrid;

public class GameEngine {
    //singleton
    private static GameEngine instance;
    private GameGrid grid = null;
    private int selectedPosX = -1, selectedPosY = -1;

    private GameEngine(){}

    public static GameEngine getInstance() {
        if(instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public void createGrid(Context context) {
        int [][] sudoku = SudokuGenerator.getInstance().generateGrid();
        sudoku = SudokuGenerator.getInstance().removeElements(sudoku);
        grid = new GameGrid(context);
        grid.setGrid(sudoku);
    }

    public GameGrid getGrid() {
        return grid;
    }

    public void setSelectedPosX(int x, int y) {
        this.selectedPosX = x;
        this.selectedPosY = y;
    }
    public void setNumber(int number) {
        if (selectedPosY != -1 && selectedPosX != -1) {
            grid.setItem(selectedPosX, selectedPosY, number);
        }
    }
}
