package Recursion;

import java.util.*;

public class Boardpath {

    // a) Count number of ways
    static int countWays(int curr, int end, int M) {
        if (curr == end) return 1;   // Reached end
        if (curr > end) return 0;    // Overshoot

        int ways = 0;
        for (int dice = 1; dice <= M; dice++) {
            ways += countWays(curr + dice, end, M);
        }
        return ways;
    }

    // b) Print all paths
    static void printPaths(int curr, int end, int M, String path) {
        if (curr == end) {
            System.out.print(path + " ");
            return;
        }
        if (curr > end) return;

        for (int dice = 1; dice <= M; dice++) {
            printPaths(curr + dice, end, M, path + dice);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Board size
        int M = sc.nextInt(); // Dice faces

        // b) Print all paths
        printPaths(0, N, M, "");
        System.out.println();

        // a) Count number of ways
        System.out.println(countWays(0, N, M));
    }
}

