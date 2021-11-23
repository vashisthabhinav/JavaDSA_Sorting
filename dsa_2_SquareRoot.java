package com.company.dsa;
import java.util.Scanner;

public class dsa_2_SquareRoot {
    static public int mySqrt1(int x) {
        int start = 0, end = x;
        int mid;

        int ans = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (mid * mid == x) {
                ans = mid;
                break;// Break statement is necessary to exit the loop
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
        System.out.println("Enter the first number: ");
        Scanner sc1= new Scanner(System.in);
        int a = sc1.nextInt();
        System.out.print("The square root of this integer is (Integer part): ");
        System.out.println(mySqrt1(a));
        System.out.println("Enter the second number: ");
        Scanner sc2=new Scanner(System.in);
        int b = sc1.nextInt();
        System.out.print("The square root of this integer is (Integer part): ");
        System.out.println(mySqrt2(b));
    }
}

