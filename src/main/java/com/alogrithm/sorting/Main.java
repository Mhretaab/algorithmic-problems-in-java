package com.alogrithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.add(11);
        prices.add(5);
        prices.add(9);
        prices.add(1);

        Collections.sort(prices);
        System.out.println(prices);
    }
}
