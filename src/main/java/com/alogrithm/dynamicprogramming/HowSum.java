package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

    public static List<Integer> howSum(int targetSum, int[] A, Map<Integer, List<Integer>> memo) {
        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int number : A) {
            int remainder = targetSum - number;
            List<Integer> remainderResult = howSum(remainder, A, memo);
            if (remainderResult != null) {
                remainderResult.add(number);
                memo.put(targetSum, remainderResult);
                return memo.get(targetSum);
            }
        }

        memo.put(targetSum, null);
        return memo.get(targetSum);
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 4, 7};
        int[] B = {7, 14};

        System.out.println(howSum(8, A, null));
        System.out.println(howSum(300, B, null));
    }
}
