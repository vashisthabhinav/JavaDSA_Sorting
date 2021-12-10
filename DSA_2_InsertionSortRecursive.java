package com.company.dsa;

import java.util.Arrays;

public class DSA_2_InsertionSortRecursive {

        public static void main(String[] args) {
            int nums[] = {1, 5, 2, 54, 67, -21};
            System.out.println("Array before insertionSort" + Arrays.toString(nums));
            insertionSortRecursive(nums, nums.length);
//        insertionSort(nums,2);
            System.out.println("Array after insertionSort" + Arrays.toString(nums));
        }
        public static void insertionSortRecursive(int[] input, int numItems) {

            if (numItems < 2) {
                return;
            }

            insertionSortRecursive(input, numItems - 1);

            int newElement = input[numItems - 1];
        /*
        Instead of using a loop to increase the sorted partition from left to right, we are using recursion  to increase the sorted partition from left to right.
        By the time we get here, after recursion, we only have to sort the last item. So now, we do a regular insertion sort.
         */

            int i;

            for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
                input[i] = input[i - 1];
            }

            input[i] = newElement;

            System.out.println("Result of call when numItems = " + numItems);
            for (i = 0; i < input.length; i++) {
                System.out.print(input[i]);
                System.out.print(", ");
            }
            System.out.println();
            System.out.println("---------------------");


        }
        public static void insertionSort(int []intArray,int numItems){
            if(numItems== intArray.length){
                return;
            }
            int newElement = intArray[numItems];
            int i= numItems;
            while (i>0 && intArray[i-1]>newElement){
                intArray[i]=intArray[i-1];
                i--;
            }
            intArray[i]=newElement;
            System.out.println("Result of call when numItems = " + numItems);
            for (i = 0; i < intArray.length; i++) {
                System.out.print(intArray[i]);
                System.out.print(", ");
            }
            System.out.println();
            System.out.println("---------------------");
            insertionSort(intArray,numItems+1);

        }

}

