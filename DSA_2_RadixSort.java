package com.company.dsa;

import java.util.Arrays;

/*
- Makes assumptions about the data
- Data must have same width and radix
- Radix is the number of unique digits or values that a numbering system or an alphabet has
- For ex, the radix for the decimal system is 10 and 26 for english alphabets
- Width means the number of digits or letters
- For ex, number 1235 have width 4, Hello has width of 5
- Because of this, data must be integers or strings
- Sort based on each individual digit or letter position
- Start at rightmost position
- Must be a stable sort algorithm in each stage
- First we sort array using one's position then ten's and so on
 */
public class DSA_2_RadixSort {
    public static void main(String[] args) {
        int radixArray[] = { 4725, 4586, 1330, 8792, 1594, 5729 };
        System.out.println("Array before Radix sort" + Arrays.toString(radixArray));
        radixSort(radixArray, 10, 4);
        System.out.println("Array after Radix sort" + Arrays.toString(radixArray));
    }
    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] =
                    input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }


    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
/*
- Counting sort is often used as the sort algorithm for radix sort (must be stable counting sort)
- O(n) time complexity because we are making assumptions about the data we are sorting
- Even so, it often runs slower than O(n log n) algorithms because of the overhead involved (you have to isolate each individual & letter at each phase)
- In-place depends on which sort you use
- Stable algorithm
 */
/*
STABLE COUNTING SORT
- Requires extra steps
- Can calculate where values should be written back to the original array
- Writing the values into the array in backwards order ensure stability
- We create a temporary array that matches the length of the array we are sorting
- We can use counts to figure out which range of indices in the temporary array will be occupied by each value. For ex, we can figure out that the two values with 2's in the 10's position will occupy indices 0 & 1 in the temporary array. The value with '3' in the 10's position will occupy index 2 and so on.
- After the first pass, we adjust the counts. Instead of the number of values have a specific 10's value, we want to store how many values have a specific 10's value or less
- For ex, we want to store 3 at index 3, because 3 values have a 10's value of 3 or less
- We can calculate each adjusted count by adding up the counts up to and including the 10's value
- This works because we traverse the input array from right to left, and we write duplicate values into the temp array from right to left
- If we know that duplicate values will go into positions 3 & 4, we write the rightmost value in the input array into position 4, and leftmost value to position 3
- This preserves the relative positioning of duplicate values
- By adjusting the counting array after the initial pass, we can map values to indices in the temp array
- Can also make linked lists to make counting sort stable
 */