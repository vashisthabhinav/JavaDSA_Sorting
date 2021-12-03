package com.company.dsa;

import java.nio.file.LinkPermission;
import java.util.Arrays;
/*
Divide and conquer algorithm
Recursive algorithm
Two phases: Splitting and Merging
Splitting phase leads to faster sorting during the Merging phase
Splitting is logical. We don't create new arrays
SPLITTING PHASE
Start with an unsorted array
Divide the array into two arrays, which are unsorted. The first array is the left array and the second array is the right array.
Split the left and right arrays into two arrays each.
Keep splitting until all the arrays have only one element each-these arrays are sorted.
MERGING PHASE
Merge every left/right pair of sibling arrays into a sorted arrays
After the first merge, we'll have a bunch of 4-element sorted arrays.
Then merge those sorted arrays (left/right siblings) to end up with a bunch of 4-element sorted arrays.
Repeat until you have a single sorted arrays.
Not-in-place. Uses temporary arrays
MERGING PROCESS
We merge siblings left and right arrays
We create a temporary array large enough to hold all the elements of the right array.
We compare left[i] to right[j]. If left is smaller, we copy it to the temp array and increment i by 1. If right is smaller, we copy ot to temp array and increment j by 1
We repeat this process until all elements in the two arrays have been processed.
At this point, the temporary array contains the merged values in sorted order.
We then copy this temporary array back to the original input array, at the correct positions.
If the array is at positions x to y, and the right array is at y+1 to z, then after we copy. Positions x to z willl be the sorted
.--------------------------------------------------
- Not an in-place algorithm
- O(nlogn)- base 2 time complexity
- Stable algorithm
 */
public class DSA_2_MergeSort {
    public static void main(String[] args) {
        int intArray[] = {1, 5, 2, 54, -67, 21};
        System.out.println("Array before Shell sort" + Arrays.toString(intArray));
        MergeSort(intArray,0, intArray.length);
        System.out.println("Array after Shell sort" + Arrays.toString(intArray));
    }
    public static void MergeSort(int[] input, int start, int end) {
        if (end-start<2){
            return;
        }
        int mid = (start + end) / 2;
        MergeSort(input, start, mid);
        MergeSort(input, mid, end);
        Merge(input, start, mid, end);

    }
    public static void Merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i=start;
        int j=mid;
        int tempIndex = 0;
        int[] temp=new int[end-start];
        while (i < mid && j < end){
            temp[tempIndex++] = input[i]<=input[j] ? input[i++] : input[j++];
            //'?'--> is used as one line replacement for if-then-else statement.
            // It is the only conditional operator which takes three operands.
        }
        System.arraycopy(input,i,input,start+tempIndex,mid-i);
        System.arraycopy(temp,0,input,start,tempIndex);
        // arraycopy--> Copies an array from the specified source array,
        // beginning at the specified position, to the specified position of the destination array
    }
}
