package com.alogrithm.dynamicprogramming;

public class KnapsackProblem {
    private int[] weights;
    private int[] values;
    private int numberOfItems;
    private int[][] memoizeTable;
    private int capacity;

    public KnapsackProblem(int[] weights, int[] values, int capacity) {
        this.weights = weights;
        this.values = values;
        this.capacity = capacity;
        this.numberOfItems = this.values.length;
        this.memoizeTable = new int[numberOfItems + 1][capacity + 1];
    }

    public int solution() {
        return knapSack(capacity, numberOfItems, weights, values);
    }

    public int naiveSolution(){
        return naiveKnapsack(capacity, numberOfItems, weights, values);
    }

    private int naiveKnapsack(int capacity, int numberOfItems, int[] weights, int[] values) {
        if(capacity == 0 || numberOfItems == 0){
            return 0;
        }

        if(weights[numberOfItems - 1] > capacity){
            return naiveKnapsack(capacity, numberOfItems - 1, weights, values);
        }

        int left = naiveKnapsack(capacity - weights[numberOfItems - 1], numberOfItems - 1, weights, values) + values[numberOfItems -1];
        int right = naiveKnapsack(capacity, numberOfItems - 1, weights, values);

        return max(left, right);
    }

    private int knapSack(int capacity, int numberOfItems, int[] weights, int[] values) {
        for(int i = 1; i < numberOfItems + 1; ++i){
            for(int w = 1; w < capacity + 1; ++w){
                int itemNotTaking = memoizeTable[i - 1][w];
                int itemTaking = 0;

                if(weights[i-1] <= w){
                    itemTaking = values[i-1] + memoizeTable[i - 1][w - weights[i-1]];
                }

                memoizeTable[i][w] = max(itemTaking, itemNotTaking);
            }
        }

        int totalBenefit = memoizeTable[numberOfItems][capacity];

        showResult();

        return totalBenefit;
    }

    private void showResult() {
        for(int i = 0; i < numberOfItems + 1; ++i){
            for(int c = 0; c < capacity + 1; ++c){
                System.out.print(" " + memoizeTable[i][c] + " ");
            }

            System.out.println();
        }
    }

    private int max(int left, int right) {
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        int values[] = new int[]{60, 100, 120};
        int weights[] = new int[]{10, 20, 30};
        int capacity = 30;

        System.out.println(new KnapsackProblem(weights, values, capacity).naiveSolution());
        System.out.println(new KnapsackProblem(weights, values, capacity).solution());
    }
}
