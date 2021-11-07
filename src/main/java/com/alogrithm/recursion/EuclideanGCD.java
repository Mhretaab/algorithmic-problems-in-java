package com.alogrithm.recursion;

public class EuclideanGCD {

    public static void main(String[] args) {
        System.out.println(gcd(7, 9));
    }

    public static int gcd(int A, int B){
        if(B == 0)
            return A;

        return gcd(B, A%B);
    }
}
