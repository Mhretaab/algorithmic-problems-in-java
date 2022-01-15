package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class BestSumTabulation {
    public static List<Integer> solve(int targetSum, int[] numbers){
        Object[] table = new Object[targetSum + 1];
        table[0] = new ArrayList<>();

        List<Integer> best = null;

        for(int i = 0; i <  table.length; i++){
            for (int number : numbers){
                if((i + number) < table.length && table[i] != null){
                    List<Integer> tableI = (List<Integer>) table[i];

                }
            }
        }


        return best;
    }
}
