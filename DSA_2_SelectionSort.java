package com.company.dsa;
/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 * While in descending order, It analyses full array and finds the max element and add it to last and so on.
 * It sorts the array one by one.
 */

import java.util.Arrays;

public class DSA_2_SelectionSort {
    public static void main(String[] args) {
        int nums[] = {1, 5, 2, 54, 67, 21};
        System.out.println("Array before selectionSort" + Arrays.toString(nums));
        selectionSortAsc(nums);
        System.out.println("Array after selectionSort(Ascending order)" + Arrays.toString(nums));
        selectionSortDsc(nums);
        System.out.println("Array after selectionSort(Descending order)" + Arrays.toString(nums));
    }

    public static void selectionSortDsc(int[] nums) {
        for (int i=nums.length-1; i>0 ; i--) {
//            System.out.println(i);
            for (int j= i-1; j>=0  ; j--) {
//                System.out.println(j);
                if (nums[j]>nums[i]){
                    swap(nums,i,j);
                }
            }
        }
    }

    public static void selectionSortAsc(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    swap(nums,i,j);
                }
            }

        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}