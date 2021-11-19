package com.company.dsa;

import java.util.Scanner;

public class DSA_1_PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        prime(n);
    }

    public static void prime(int n) {
        boolean prime = true;
        for (int i=2;i<=n;i++){
            int remainder=n%i;
            if(remainder==0){
                prime=false;
                break;
            }
        }
        if (prime){
            System.out.println(n+" is a Prime Number");

        }
        else {
            System.out.println(n+" is not a Prime Number");
        }
    }
}