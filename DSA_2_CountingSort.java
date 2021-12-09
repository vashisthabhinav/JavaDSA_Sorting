package com.company.dsa;
/*
- Makes assumptions about the data
- Doesn't use comparisons
- Counts the number of occurrences of each value
- Only work with non-negative discrete values(can't work with float, strings)
- Values must be within a specified range
 */

import java.util.Arrays;
/*
Assume we have values between 1-10 inclusive
We have 10 possible values, so we create a counting array of length 10
Traverse the input array from left to right
Use the counting array to track how many of each value are in the input array
Using the counts in the counting array, write the values in the sorted order to the input array
 */
public class DSA_2_CountingSort {

    public static void main(String[] args) {
        int [] intArray= { 3, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        System.out.println("Array before Counting sort" + Arrays.toString(intArray));
        CountingSort(intArray, 1, 10);
        System.out.println("Array after Counting sort" + Arrays.toString(intArray));
    }
    public static void CountingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }

    }
}
/*
- Not an in-place algorithm
- O(n) time complexity- Can achieve this because we are making assumptions about the data we are sorting
- If we want the sort to be stable, we have to do some extra steps
 */