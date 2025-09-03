package Recursion;

import java.util.Scanner;

public class oddeven {
    static void printOdd(int n) {
        if (n <= 0) return; // base case
        if (n % 2 == 1) {
            System.out.println(n);
        }
        printOdd(n - 1);
    }
    static void printEven(int n) {
        if (n <= 0) return; // base case
        printEven(n - 1);   // recursive call first
        if (n % 2 == 0) {
            System.out.println(n);
        }
    }
	public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        printOdd(n);   // print odds in decreasing order
        printEven(n);
    }
}
