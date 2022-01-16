package com.company.dsa;

/*
Bucket Sort-
- Uses hashing.
- Makes assumptions about the data, like radix and counting sort.
- Because it makes assumptions, it can sort in O(n) time.
- Performs best when hashed values of items being sorted are evenly distributed, so there aren't many collisions.
- Not in-place algorithm(Also depends upon the algorithm, if the algorithm used is stable, bucket sort will become stable.)
- Stability will depend on sort algorithm used to sort the buckets- ideally, you want a stable sort
- To achieve O(n), must have only one item per bucket.
- Insertion sort is often used to sort the buckets, coz it is fas when the number of items is small.

Working-
1) Distribute the items in each bucket based on their hashed values(scattering phase)
2) Sort the items in each bucket.
3) Merge the buckets- can just concatenate them i.e, link them together (gathering phase)
- A generalization of counting sort.

In order for the third step to work-
- The values in bucket X must be greater than the values in bucket X-1 and less than the values in bucket X+1
- This means that the hash function we use must meet this requirement.
 */


import java.util.*;

public class DSA_2_BucketSort {

    public static void main(String[] args) {
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);

        System.out.println(Arrays.toString(intArray));
    }


    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];
        //Creating the array that is going to hold the arraylist.

        for (int i = 0; i < buckets.length; i++) {
            //Traversing the buckets

            // Using linked lists for the buckets
            //buckets[i] = new LinkedList<Integer>();

            // Using arraylists as the buckets
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < input.length; i++) {
            //Traversing the input array
            buckets[hash(input[i])].add(input[i]);
            /*
            The index that we want of the bucket that we are going to put the value into will be at the hashed value
            For example, 54, hashed value is 5, and we add it into buckets 5. And buckets 5 is an array list, so the add method is used to add the value 54 into the buckets arraylist.

             */
        }

        for (List bucket: buckets) {
            //Sorting the buckets
            Collections.sort(bucket);
            //It uses an adaptive merge sort
        }


        //Gathering step
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            //Traversing the array
            for (int value: buckets[i]) {
                input[j++] = value;
            }

            /*
            We are traversing this array, the buckets array(the outer loop is traversing the buckets array)
            And the inner loop is traversing the arraylist that's at buckets[i]
            So for each bucket, we are traversing that bucket and copying the values into the input array.
             */

        }
    }

    private static int hash(int value) {

        return value / 10;
    }

}

