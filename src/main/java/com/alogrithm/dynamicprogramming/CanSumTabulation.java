package com.alogrithm.dynamicprogramming;

import java.util.Arrays;

public class CanSumTabulation {
    public static boolean solve(int targetSum, int[] numbers){
        boolean[] table = new boolean[targetSum + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for(int i = 0; i < table.length; ++i){
            for(int number : numbers){
                if((i + number) < table.length){
                    if(table[i]){
                        table[i + number] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static void main(String[] args) {
        System.out.println(solve(7, new int[]{2, 4}));
        System.out.println(solve(7, new int[]{5,3,4,7}));
        System.out.println(solve(300, new int[]{7, 14}));
    }
}
