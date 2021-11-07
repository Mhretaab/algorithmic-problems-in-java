package com.alogrithm.recursion;

public class Factorial {

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(factorial(15));
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        System.out.println(factorialCalcu(15));
        System.out.println(System.nanoTime() - start);
    }

    public static int factorial(int N){
        if(N == 1)
            return 1;

        return N * factorial(N - 1);
    }

    public static int factorialWithAccumulator(int accumulator, int N){
        if(N == 1){
            return accumulator;
        }

        return factorialWithAccumulator(accumulator*N, N-1);
    }

    public static int factorialCalcu(int N){
        return factorialWithAccumulator(1, N);
    }
}
