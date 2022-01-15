package com.alogrithm.backtracking;

public class QueensProblem {
    private final int[][] chessTable;
    private final int numberOfQueens;

    public QueensProblem(int numberOfQueens) {
        this.chessTable = new int[numberOfQueens][numberOfQueens];
        this.numberOfQueens = numberOfQueens;
    }

    public void solve() {
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("There is no solution to the problem");
        }
    }

    private boolean setQueens(int colIndex) {
        if(colIndex == numberOfQueens)
            return true;

        for(int rowIndex = 0; rowIndex < numberOfQueens; ++rowIndex){
            if(isPlaceValid(rowIndex, colIndex)){
                chessTable[rowIndex][colIndex] = 1;

                if(setQueens(colIndex + 1)){
                    return true;
                }
                //BACKTRACKING!!!
                chessTable[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {

        //check row
        for(int i = 0; i < colIndex; ++i){
            if(chessTable[rowIndex][i] == 1){
                return false;
            }
        }

        for(int i = rowIndex, j = colIndex; i >= 0 && j >= 0; --i, --j){
            if(chessTable[i][j] == 1){
                return false;
            }
        }

        for(int i = rowIndex, j = colIndex; i < numberOfQueens && j >= 0; ++i, --j){
            if(chessTable[i][j] == 1){
                return false;
            }
        }

        return true;
    }

    private void printQueens() {
        for (int i = 0; i < numberOfQueens; ++i) {
            for (int j = 0; j < numberOfQueens; ++j) {
                if (chessTable[i][j] == 1)
                    System.out.print(" * ");
                else
                    System.out.print(" - ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new QueensProblem(2).solve();
    }
}
