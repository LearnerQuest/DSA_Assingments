package Recursion;

import java.util.*;

public class Mazepath_D{
    // a. Count paths (recursive)
    static int countPaths(int r, int c, int n1, int n2) {
        if (r == n1 - 1 && c == n2 - 1) {
            return 1;
        }
        if (r >= n1 || c >= n2) {
            return 0;
        }

        int down = countPaths(r + 1, c, n1, n2);     // V
        int right = countPaths(r, c + 1, n1, n2);    // H
        int diag = countPaths(r + 1, c + 1, n1, n2); // D

        return down + right + diag;
    }

    // b. Collect all paths
    static void collectPaths(int r, int c, int n1, int n2, String path, List<String> paths) {
        if (r == n1 - 1 && c == n2 - 1) {
            paths.add(path);
            return;
        }
        if (r >= n1 || c >= n2) {
            return;
        }

        collectPaths(r + 1, c, n1, n2, path + "V", paths); // V
        collectPaths(r, c + 1, n1, n2, path + "H", paths); // H
        collectPaths(r + 1, c + 1, n1, n2, path + "D", paths); // D
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();

        // Collect all paths
        List<String> paths = new ArrayList<>();
        collectPaths(0, 0, N1, N2, "", paths);

        // Print all paths in one line, space separated
        System.out.println(String.join(" ", paths));

        // Print total count
        System.out.println(countPaths(0, 0, N1, N2));
    }
}

