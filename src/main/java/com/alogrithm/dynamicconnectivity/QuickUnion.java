package com.alogrithm.dynamicconnectivity;

import java.util.*;

public class QuickUnion {
    private int[] id;
    Map<Integer, Integer> memo;

    public QuickUnion(int size) {
        id = new int[size];
        memo = new HashMap<>();

        for(int i = 0; i < size; ++i)
            id[i] = i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);

        id[rootP] = rootQ;
    }

    public int root(int p) {
        //if(memo.containsKey(p)) return memo.get(p);

        int i = p;
        while(p != id[p]){
            p = id[p];
        }

       // memo.put(i, p);
        return p;
    }

    public int numberOfComponents(){
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < id.length; ++i){
            roots.add(root(i));
        }

        return roots.size();
    }

    public void printArray(){
        System.out.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        //{0}, {4, 2, 3}, {1,5,6,7}
        QuickUnion quickUnion = new QuickUnion(8);
        quickUnion.union(4, 2);
        quickUnion.union(2, 3);
        quickUnion.union(1, 5);
        quickUnion.union(5, 6);
        quickUnion.union(6, 7);

        quickUnion.printArray();

        System.out.println(quickUnion.connected(1, 7));
        System.out.println(quickUnion.connected(4, 7));
        System.out.println(quickUnion.numberOfComponents());
    }
}
