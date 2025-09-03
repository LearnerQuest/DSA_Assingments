package Recursion;

import java.util.*;

public class N_Knight {

    // Check if queen can be placed safely
    static boolean isSafe(int[][] board, int r, int c, int n) {
        // check column
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) return false;
        }

        // check upper-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // check upper-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    // Recursive function to place queens
    static void placeQueens(int[][] board, int r, int n, String config, List<String> results) {
        if (r == n) { // all queens placed
            results.add(config.trim());
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c, n)) {
                board[r][c] = 1;
                placeQueens(board, r + 1, n, config + "{" + r + "-" + c + "} ", results);
                board[r][c] = 0; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        List<String> results = new ArrayList<>();

        placeQueens(board, 0, n, "", results);

        // Print all configurations
        for (String res : results) {
            System.out.print(res + "  ");
        }
        System.out.println();
        // Print count
        System.out.println(results.size());
    }
}
