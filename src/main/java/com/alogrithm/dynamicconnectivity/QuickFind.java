package com.alogrithm.dynamicconnectivity;

import java.util.HashSet;
import java.util.Set;

public class QuickFind {
    private int[] id;

    public QuickFind(int size) {
        id = new int[size];

        for(int i = 0; i < size; ++i)
            id[i]= i;
    }

    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];

        for(int i = 0; i < id.length; ++i){
            if(id[i] == pid) id[i] = qid;
        }
    }

    public int numberOfComponents(){
        Set<Integer> sets = new HashSet<>();
        for(int i : id){
            sets.add(i);
        }

        return sets.size();
    }

    public static void main(String[] args) {
        //{0}, {4, 2, 3}, {1,5,6,7}
        QuickFind quickFind = new QuickFind(8);
        quickFind.union(4, 2);
        quickFind.union(2, 3);
        quickFind.union(1, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 7);

        System.out.println(quickFind.connected(0, 7));
        System.out.println(quickFind.connected(1, 7));
        System.out.println(quickFind.numberOfComponents());
    }
}
