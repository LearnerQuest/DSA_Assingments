package  Recursion;
import java.util.*;

public class SubSequence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // Print all non-empty subsequences (space separated)
        printSubsequences(s, 0, "");
        System.out.println();

        // Print total number of subsequences (including the empty subsequence)
        long total = countSubsequences(s, 0);
        System.out.println(total);
    }

    // returns 2^(n-idx)
    static long countSubsequences(String s, int idx) {
        if (idx == s.length()) return 1;
        long exclude = countSubsequences(s, idx + 1);
        long include = countSubsequences(s, idx + 1);
        return exclude + include;
    }

    // exclude-first produces the sample ordering (prints non-empty at base case)
    static void printSubsequences(String s, int idx, String current) {
        if (idx == s.length()) {
            if (!current.isEmpty()) {
                System.out.print(current + " ");
            }
            return;
        }
        // Exclude current character first (so right-most combinations print earlier)
        printSubsequences(s, idx + 1, current);
        // Include current character
        printSubsequences(s, idx + 1, current + s.charAt(idx));
    }
}
