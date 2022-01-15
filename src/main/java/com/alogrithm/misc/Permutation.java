package com.alogrithm.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public static List<List<Integer>> solve(List<Integer> A) {
        if (A.size() <= 1) return new ArrayList<>() {{
            add(A);
        }};

        List<List<Integer>> result = new ArrayList<>();

        for (Integer i : A) {
            List<Integer> elements = A.stream().collect(Collectors.toList());
            elements.remove(i);
            List<List<Integer>> combinations = solve(elements);
            for (List<Integer> combination : combinations) {
                combination.add(0, i);
                result.add(combination);
            }

        }

        return result;
    }

    public static int[][] solve(int[] numbers){
        int totalCombinations = 1;

        for(int i = numbers.length; i >= 1; --i){
            totalCombinations *= i;
        }

        int[][] result = new int[totalCombinations][numbers.length];

        int[] rest = Arrays.copyOfRange(numbers, 0, numbers.length);

        for(int i : numbers){
            int[] left;
            int[] right;

            if(i - 1 >= 0)
                left = Arrays.copyOfRange(numbers, 0, i - 1) ;

            if(i + 1 < numbers.length)
                right = Arrays.copyOfRange(numbers, i + 1, numbers.length);


        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<Integer> array = Arrays.stream(numbers).boxed().collect(Collectors.toList());

        System.out.println(solve(array));
    }
}
