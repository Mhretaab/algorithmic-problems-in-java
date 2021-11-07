package com.alogrithm.recursion;

import java.util.Arrays;

public class LinearAndBinarySearch{

    private int[] array;

    public LinearAndBinarySearch(int[] array){
        this.array = array;
    }

    public int linearSearch(int item){
        for(int i = 0; i < array.length; ++i){
            if(array[i] == item){
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int item){
        return binarySearch(0, array.length-1, item);
    }

    private int binarySearch(int startIndex, int endIndex, int item){
        if(startIndex > endIndex)
            return -1;

        int middleIndex = (startIndex + endIndex)/2;

        if(array[middleIndex] == item){
            return middleIndex;
        }else if(array[middleIndex] > item){
            return binarySearch(startIndex, middleIndex-1, item);
        }else {
            return binarySearch(middleIndex + 1, endIndex, item);
        }
    }

    public static void main(String[] args) {
        int[] array1 = {13, 2, 67, 34, 11, 8, 90, 23};
        LinearAndBinarySearch linearAndBinarySearch = new LinearAndBinarySearch(array1);
        System.out.println(linearAndBinarySearch.linearSearch(67));

        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println(linearAndBinarySearch.binarySearch(2));
    }
}
