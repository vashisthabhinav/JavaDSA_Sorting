package com.company.dsa;

public class dsa_2_SquareRoot {
    static public int mySqrt(int x) {
        int start = 0, end = x;
        int mid;

        int ans = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (mid * mid == x) {
                ans = mid;
                break;// Break state is necessary to exit the loop
            }

             if (mid * mid < x) {
                start = mid + 1;
                ans = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
    }
}

