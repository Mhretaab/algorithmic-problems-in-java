package com.alogrithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public static int solve(int row, int col, Map<String, Integer> memo){
        if (memo == null)
            memo = new HashMap<>();

        String key = row + "_" + col;
        if(memo.containsKey(key))
            return memo.get(key);

        if(row == 0 || col == 0)
            return 0;

        if(row == 1 || col == 1)
            return 1;

        memo.put(key, solve(row-1, col, memo) + solve(row, col-1, memo));

        return memo.get(key);
    }

    public static long solve(long row, long col, Map<String, Long> memo){
        if (memo == null)
            memo = new HashMap<>();

        String key = row + "_" + col;
        if(memo.containsKey(key))
            return memo.get(key);

        if(row == 0 || col == 0)
            return 0;

        if(row == 1 || col == 1)
            return 1;

        memo.put(key, solve(row-1, col, memo) + solve(row, col-1, memo));

        return memo.get(key);
    }

    public static void main(String[] args) {
        System.out.println(solve(18l,18l,null));
    }
}
