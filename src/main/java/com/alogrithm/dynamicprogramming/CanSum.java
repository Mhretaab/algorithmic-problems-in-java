package com.alogrithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
    public static boolean solve(int targetNum, int[] numbers, Map<Integer, Boolean> memo){
        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(targetNum))
            return memo.get(targetNum);

        if(targetNum == 0) return true;

        if(targetNum < 0) return false;

        for(int i : numbers){
            int remainder = targetNum - i;
            memo.put(remainder, solve(remainder, numbers, memo));
            if(memo.get(remainder) == true)
                return true;
        }

        memo.put(targetNum, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solve(7, new int[]{2, 4}, null));
        System.out.println(solve(7, new int[]{5,3,4,7}, null));
        System.out.println(solve(300, new int[]{7, 14}, null));
    }
}
