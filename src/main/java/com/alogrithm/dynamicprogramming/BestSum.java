package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestSum {

    //TODO: Have problem with memoization
    public static List<Integer> solve(int targetSum, int[] A, Map<Integer, List<Integer>> memo) {
        if(memo == null) {
            memo = new HashMap<>();
        }

        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> bestCombination = null;

        for (int i : A) {
            final int remainder = targetSum - i;
            final List<Integer> remainderCombination = solve(remainder, A, memo);
            if (remainderCombination != null) {

                remainderCombination.add(i);

                if (bestCombination == null || bestCombination.size() > remainderCombination.size()) {
                    bestCombination = remainderCombination.stream().collect(Collectors.toList());
                }
            }
        }

        memo.put(targetSum, bestCombination);
        return memo.get(targetSum);
    }

    public static void main(String[] args) {
        int[] a = {5, 3, 4, 7};
        int[] b = {2, 3, 5};
        int[] c = {1, 4, 5};
        int[] d = {1, 2, 5, 25};

        System.out.println(solve(7, a, null));
        System.out.println(solve(8, b, null));
        System.out.println(solve(8, c, null));
        System.out.println(solve(100, d, null));
    }
}
