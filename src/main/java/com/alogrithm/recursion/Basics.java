package com.alogrithm.recursion;

public class Basics {
    public static void main(String[] args) {
        System.out.println(sum(10));
        System.out.println("-------------");
        tail(5);
        System.out.println("--------");
        head(5);
    }

    public static int sum(int N){
        if(N == 1)//Base case
            return N;

        return N + sum(N - 1);
    }

    public static void tail(int N){
        if(N == 1)
            return;

        System.out.println(N);
        tail(N - 1);
    }

    public static void head(int N){
        if(N == 1)
            return;

        head(N - 1);
        System.out.println(N);
    }
}
