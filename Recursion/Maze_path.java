package Recursion;

import java.util.*;

public class Maze_path {
    
    // a) Count paths
    static int countPaths(int r, int c, int n1, int n2) {
        // Destination reached
        if (r == n1 - 1 && c == n2 - 1) return 1;
        // Out of bounds
        if (r >= n1 || c >= n2) return 0;

        // Explore both moves
        int down = countPaths(r + 1, c, n1, n2);  // V
        int right = countPaths(r, c + 1, n1, n2); // H

        return down + right;
    }

    // b) Return all paths in ArrayList
    static ArrayList<String> getPaths(int r, int c, int n1, int n2) {
        ArrayList<String> res = new ArrayList<>();

        // Reached destination
        if (r == n1 - 1 && c == n2 - 1) {
            res.add("");
            return res;
        }

        // Out of bounds
        if (r >= n1 || c >= n2) {
            return res;
        }

        // Move down
        ArrayList<String> downPaths = getPaths(r + 1, c, n1, n2);
        for (String path : downPaths) {
            res.add("V" + path);
        }

        // Move right
        ArrayList<String> rightPaths = getPaths(r, c + 1, n1, n2);
        for (String path : rightPaths) {
            res.add("H" + path);
        }

        return res;
    }

    // c) Print all paths directly
    static void printPaths(int r, int c, int n1, int n2, String path) {
        if (r == n1 - 1 && c == n2 - 1) {
            System.out.print(path + " ");
            return;
        }
        if (r >= n1 || c >= n2) return;

        // Down
        printPaths(r + 1, c, n1, n2, path + "V");
        // Right
        printPaths(r, c + 1, n1, n2, path + "H");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();

        // Print all paths (part c)
        printPaths(0, 0, N1, N2, "");
        System.out.println();

        // Count (part a)
        System.out.println(countPaths(0, 0, N1, N2));
    }
}

