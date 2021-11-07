package com.alogrithm.selection;

import java.util.Random;

public class QuickSelectOrHoareAlgorithm {

    private final int[] array;

    public QuickSelectOrHoareAlgorithm(int[] array) {
        this.array = array;
    }

    public int select(int k) {
        return select(0, this.array.length - 1, k-1);
    }

    private int select(int firstIndex, int lastIndex, int k) {
        int pivot = partition(firstIndex, lastIndex);

        if (pivot > k) {
            return select(firstIndex, pivot - 1, k);
        } else if (pivot < k) {
            return select(pivot + 1, lastIndex, k);
        }

        return this.array[k];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;

        swap(lastIndex, pivot);

        for (int i = firstIndex; i < lastIndex; i++) {
            if (this.array[i] > this.array[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        swap(firstIndex, lastIndex);

        return firstIndex;
    }

    private void swap(int i, int j) {
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

  /*  public static int partition(int[] arr, int low,
                                int high) {
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            // inserting elements of less value
            // to the left of the pivot location
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }

        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;

        return pivotloc;
    }

    public static int kthSmallest(int[] arr, int low,
                                  int high, int k) {
        int partition = partition(arr, low, high);
        if (partition == k - 1)
            return arr[partition];
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);
        else
            return kthSmallest(arr, low, partition - 1, k);
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 5, 3, -2, 8, 19};

        QuickSelectOrHoareAlgorithm quickSelectOrHoareAlgorithm = new QuickSelectOrHoareAlgorithm(nums);
        System.out.println(quickSelectOrHoareAlgorithm.select(2));
    }
}
