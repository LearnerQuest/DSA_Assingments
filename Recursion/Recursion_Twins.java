package Recursion;

import java.util.*;
public class Recursion_Twins {
    static int countTwins(String s, int idx) {
        if (idx + 2 >= s.length()) {
            return 0; // Base case: less than 3 chars left
        }

        int count = 0;
        if (s.charAt(idx) == s.charAt(idx + 2)) {
            count = 1;
        }

        // Move to next index
        return count + countTwins(s, idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(countTwins(str, 0));
    }
}

