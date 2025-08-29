package Recursion;

import java.util.*;

public class Dictionary_Order {
    static String input;

    // Recursive function
    static void generate(String prefix, String remaining) {
        if (remaining.isEmpty()) {
            if (prefix.compareTo(input) > 0) {
                System.out.println(prefix);
            }
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);
            String newPrefix = prefix + ch;
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            // Pruning
            if (newPrefix.compareTo(input.substring(0, Math.min(newPrefix.length(), input.length()))) < 0) {
                continue; // prefix smaller → skip
            }

            generate(newPrefix, newRemaining);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = sc.next();

        // Sort characters first so permutations come in lexicographic order
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);

        generate("", sorted);
    }
}

