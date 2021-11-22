package com.company.dsa;

import java.util.Arrays;

public class DSA_2_InsertionSort {
    public static void main(String[] args) {
        int nums[] = {1, 5, 2, 54, 67, 21};
        System.out.println("Array before insertionSort" + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("Array after insertionSort" + Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length-1 ; i++) {
            System.out.println(i);

        }
    }
}
