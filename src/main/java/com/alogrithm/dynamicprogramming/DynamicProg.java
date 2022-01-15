package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProg {


    public long fib(long n, Map<Long, Long> memo){
        if(n <= 2)
            return 1;

        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(n))
            return memo.get(n);

        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));

        return memo.get(n);
    }

    public int gridTraveler(int n, int m, Map<String, Integer> memo){
        if(memo == null)
            memo = new HashMap<>();

        String s1 = n + ", " + m;
        String s2 = m + ", " + n;

        if(memo.containsKey(s1))
            return memo.get(s1);

        if(memo.containsKey(s2))
            return memo.get(s2);

        if(n == 1 || m == 1)
            return 1;

        if(n == 0 || m == 0)
            return 0;


        String key = n + ", " + m;
        memo.put(key, gridTraveler(n - 1, m, memo) + gridTraveler(n, m - 1, memo));
        return memo.get(key);
    }

    public boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo){
        if(memo == null)
            memo = new HashMap<>();

        if(memo.containsKey(targetSum))
            return memo.get(targetSum);

        if(targetSum == 0)
            return true;

        if(targetSum < 0)
            return false;

        for(int i : numbers){
            final int remainder = targetSum - i;
            if(canSum(remainder, numbers, memo) == true){
                memo.put(targetSum, true);
                return true;
            }
        }

        memo.put(targetSum, false);
        return false;
    }

    public List<Integer> howSum(int targetSum, int[] numbers){
        if(targetSum == 0)
            return new ArrayList<Integer>();

        if(targetSum < 0)
            return null;

        for(int i : numbers){
            final int remainder = targetSum - i;
            final List<Integer> remainderResult = howSum(remainder, numbers);
            if(remainderResult != null){
                remainderResult.add(i);
                return remainderResult;
            }
        }

        return null;
    }
}
