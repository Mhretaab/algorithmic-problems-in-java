package com.alogrithm.dynamicprogramming;

import java.util.Arrays;

public class GridTravellerTabulation {
    public static long solve(int row, int col){
        long[][] gridTable = new long[row + 1][col + 1];
        for(int i = 0; i < gridTable.length; ++i){
            Arrays.fill(gridTable[i], 0);
        }

        gridTable[1][1] = 1;

        for(int i = 0; i < gridTable.length; ++i){
            for(int k = 0; k < gridTable[i].length; ++k){
                if((k + 1) < gridTable[i].length){
                    gridTable[i][k + 1] += gridTable[i][k];
                }

                if((i + 1) < gridTable.length){
                    gridTable[i + 1][k] += gridTable[i][k];
                }
            }
        }

        return gridTable[row][col];
    }

    public static void main(String[] args) {
        System.out.println(solve(3, 3));
        System.out.println(solve(18, 18));
    }
}
