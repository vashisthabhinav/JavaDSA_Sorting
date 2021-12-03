package com.company.dsa;

import java.util.Arrays;

/*
- Variation of Insertion Sort
- Insertion Sort chooses which element to insert using gap of 1
- Shell sort start using a larger gap value
- Goal is to reduce the amount of shifting required
- As the algorithm runs, the gap is reduced
- The last gap value is always 1
- A gap value of 1 is equivalent to insertion sort
- So, the algorithms does some preliminary work(using gap values greater than 1) and then becomes insertion sort
- By the time we got to insertion sort, the array has been partially sorted, so there's less shifting required.
 */
public class DSA_2_ShellSort {
    /*
    We'll base our gap on the array's length. We'll initialize the gap to array.length/2
    On each iteration, we'll divide the gap value by 2 to get the next gap value
    For our array, the gap will be initialized to 3
    On the next iteration, ot will be 1 insertion sort
     */
    public static void main(String[] args) {
        int nums[] = {1, 5, 2, 54, -67, 21};
        System.out.println("Array before Shell sort" + Arrays.toString(nums));
        ShellSort(nums);
        System.out.println("Array after Shell sort" + Arrays.toString(nums));
    }

    public static void ShellSort(int[] nums) {
        for (int gap = nums.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <nums.length ; i++) {
                int newElement= nums[i];
                int j=i;
                while (j>=gap && nums[j-gap]>newElement){
                    nums[j]=nums[j-gap];
                    j-=gap;
                }
                nums[j]=newElement;
            }
        }
    }

}
/*
- In-place algorithm
- Difficult to nail down the time complexity because it will depend on the gap. Worst case in O(n^2) but it can perform lot better
- Unstable algorithm
 */