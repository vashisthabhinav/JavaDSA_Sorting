package com.company.dsa;

public class dsa_2_SquareRoot {
    static public int mySqrt1(int x) {
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
    static public int mySqrt2(int x) { //Using one less variable
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = (start+end)/2;
            if (mid*mid <= x && (mid + 1)*(mid + 1) > x) {
                end = mid;
                break;
            } else if (mid*mid > x ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return end;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt1(50));
        System.out.println(mySqrt2(39));
    }
}

