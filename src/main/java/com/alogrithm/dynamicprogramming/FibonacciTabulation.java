package com.alogrithm.dynamicprogramming;

import java.util.Arrays;

public class FibonacciTabulation {
    public static long solve(long n){
        long[] fibTable = new long[(int)n + 1];
        Arrays.fill(fibTable, 0);
        fibTable[1] = 1;

        for(int i = 0; i < fibTable.length; ++i){
            if((i + 1) < fibTable.length){
                fibTable[i + 1] += fibTable[i];
            }

            if((i + 2) < fibTable.length){
                fibTable[i + 2] += fibTable[i];
            }
        }

        return fibTable[(int)n];
    }

    public static void main(String[] args) {
        System.out.println(solve(3));
        System.out.println(solve(5));
        System.out.println(solve(6));
        System.out.println(solve(50));
    }
}
