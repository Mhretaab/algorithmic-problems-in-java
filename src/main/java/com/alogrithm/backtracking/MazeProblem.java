package com.alogrithm.backtracking;

public class MazeProblem {
    private int[][] mazeTable;
    private int[][] solutionTable;
    private int mazeSize;
    private int[] xMoves = {0, 1};
    private int[] yMoves = {1, 0};

    public MazeProblem(int[][] mazeTable) {
        this.mazeTable = mazeTable;
        mazeSize = mazeTable.length;
        solutionTable = new int[mazeSize][mazeSize];

        for (int i = 0; i < mazeSize; i++)
            for (int j = 0; j < mazeSize; j++)
                solutionTable[i][j] = Integer.MIN_VALUE;
    }

    public void solve() {
        if (solveProblem(0, 0)) {
            showResult();
        } else {
            System.out.println("No feasible solution...");
        }
    }

    private boolean solveProblem(int x, int y) {
        if (x == (mazeSize - 1) && y == (mazeSize - 1)) {
            solutionTable[mazeSize -1][mazeSize-1] = 1;
            return true;
        }

        if(isValid(x, y)){
            solutionTable[x][y] = 1;

            if(solveProblem(x + 1, y)){
                return true;
            }

            if(solveProblem(x, y + 1)){
                return true;
            }

            //BACKTRACK!!!
            solutionTable[x][y] = Integer.MIN_VALUE;
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        if(x < 0 || x >= mazeSize) return false;
        if(y < 0 || y >= mazeSize) return false;
        if(mazeTable[x][y] == 0) return false;

        return true;
    }

    private void showResult() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (solutionTable[i][j] == 1) {
                    System.out.print(" S ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mazeTable = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1}
        };

        MazeProblem mazeProblem = new MazeProblem(mazeTable);
        mazeProblem.solve();
    }
}
