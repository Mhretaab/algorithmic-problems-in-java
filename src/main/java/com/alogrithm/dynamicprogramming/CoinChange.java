package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    public static List<List<Integer>> solve(int amount, int[] denominations){
        if(amount == 0) return new ArrayList<>(){{add(new ArrayList<>());}};
        if(amount < 0) return null;

        List<List<Integer>> result = new ArrayList<>();

        for(int coin : denominations){
            int remainder = amount - coin;
            List<List<Integer>> subResult = solve(remainder, denominations);

            if(subResult != null){
                for(List<Integer> combination : subResult){
                    combination.add(coin);
                    result.add(combination);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int amount = 7;
        int[] denominations = {1,2,5};

       // solve(amount, denominations);
        System.out.println(solve(amount, denominations));
    }
}
