package com.alogrithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HowSumTabulation {

    public static List<Integer> solve(int targetSum, int[] numbers){
        Object[] table = new Object[targetSum + 1];
        Arrays.fill(table, null);
        table[0] = new ArrayList<>();

        for(int i = 0; i < table.length; ++i){
            for(int number : numbers){
                if((i + number) < table.length){
                    if(table[i] != null){
                        ArrayList<Integer> tableI = (ArrayList<Integer>) table[i];
                        List<Integer> solution = tableI.stream().collect(Collectors.toList());
                        solution.add(number);
                        table[i + number] = solution;
                    }
                }
            }
        }

        return (List<Integer>) table[targetSum];
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 3, 4, 7};
        int[] B = {7, 14};

        System.out.println(solve(8, A));
        System.out.println(solve(6, A));
        System.out.println(solve(300, B));
        System.out.println(solve(56, B));
    }
}
