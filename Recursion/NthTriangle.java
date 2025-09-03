package Recursion;

import java.util.Scanner;

public class NthTriangle {
    static int triangle(int n) {
        if (n == 1) return 1; // base case
        return n + triangle(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(triangle(n));
    }
}
