package com.company.dsa;
/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 * Example:
 * First Pass:
 * ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
 * ( 1 5 4 2 8 ) –> ( 1 4 5 2 8 ), Swap since 5 > 4
 * ( 1 4 5 2 8 ) –> ( 1 4 2 5 8 ), Swap since 5 > 2
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.
 * Second Pass:
 * ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
 * ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
 * Third Pass:
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 * ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
 */

import java.util.Arrays;

public class DSA_2_BubbleSort {
    public static void main(String[] args) {
        int nums[]={1,5,2,54,67,21};
        System.out.println("Array before bubbleSorting"+Arrays.toString(nums));
//        bubbleSort1(nums);
        bubbleSort2(nums);        
        System.out.println("Array after bubbleSorting"+Arrays.toString(nums));
    }
//  Method-1
    public static void bubbleSort1(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length-1-i ; j++) {
                if (nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }
    //  Method-2
    public static void bubbleSort2(int []nums){
        for (int i = nums.length-1; i >0 ; i--) {
            for (int j = 1; j <i ; j++) {
                if (nums[j+1]<nums[j]){
                    swap(nums, j,j+1);
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
