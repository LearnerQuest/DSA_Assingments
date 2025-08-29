package Recursion;

import java.util.*;

public class TowerOFHonai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // number of rings
        towerOfHanoi(N, 'A', 'B', 'C');
    }

    static void towerOfHanoi(int n, char from, char to, char helper) {
        if (n == 0) return;

        // Step 1: Move n-1 rings from source to helper
        towerOfHanoi(n - 1, from, helper, to);

        // Step 2: Move the largest ring directly
        System.out.println("Moving ring " + n + " from " + from + " to " + to);

        // Step 3: Move n-1 rings from helper to destination
        towerOfHanoi(n - 1, helper, to, from);
    }
}

