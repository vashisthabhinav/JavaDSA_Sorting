package com.company.dsa;

import java.util.Arrays;
/*
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before.
Move the greater elements one position up to make space for the swapped element.
 */
public class DSA_2_InsertionSort {
    public static void main(String[] args) {
        int nums[] = {1, 5, 2, 54, 67, 21};
        System.out.println("Array before insertionSort" + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("Array after insertionSort" + Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        for (int unsortedIndex = 1; unsortedIndex < nums.length ; unsortedIndex++) {
            int key=nums[unsortedIndex];
            int i;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position */

            for (i = unsortedIndex; i >0 && nums[i-1]>key ; i--) {
                nums[i]=nums[i-1];
            }
            nums[i]=key;
        }
    }

}
