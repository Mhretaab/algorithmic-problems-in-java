package com.alogrithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Map<Integer, Integer> memoTable;

    public Fibonacci() {
        this.memoTable = new HashMap<>();
        this.memoTable.put(0, 0);
        this.memoTable.put(1,1);
    }

    public int calculate(int N){
        if(this.memoTable.containsKey(N)){
            return this.memoTable.get(N);
        }

        int a = calculate(N -1);
        this.memoTable.put(N - 1, a);
        int b = calculate(N - 2);
        this.memoTable.put(N - 2, b);

        this.memoTable.put(N, a + b);

        return a + b;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        //0 1 1 2 3 5 8 13
        System.out.println(fibonacci.calculate(5));
        System.out.println(fibonacci.calculate(7));
        System.out.println(fibonacci.calculate(20));
        System.out.println(fibonacci.calculate(50));
    }
}
