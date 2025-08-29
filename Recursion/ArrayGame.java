package Recursion;

import java.util.*;

public class  ArrayGame {
    static Map<String, Integer> dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // number of test cases
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            dp = new HashMap<>();
            System.out.println(maxScore(arr, 0, N - 1));
        }
    }

    static int maxScore(int[] arr, int l, int r) {
        if (l >= r) return 0;
        String key = l + "," + r;
        if (dp.containsKey(key)) return dp.get(key);

        long total = 0;
        for (int i = l; i <= r; i++) total += arr[i];

        long prefix = 0;
        int best = 0;
        for (int i = l; i < r; i++) {
            prefix += arr[i];
            long suffix = total - prefix;
            if (prefix == suffix) {
                int leftScore = maxScore(arr, l, i);
                int rightScore = maxScore(arr, i + 1, r);
                best = Math.max(best, 1 + Math.max(leftScore, rightScore));
            }
        }
        dp.put(key, best);
        return best;
    }
}
