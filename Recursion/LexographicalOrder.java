package Recursion;


public class LexographicalOrder {
    public static void main(String args[]) {
        // Your Code Here
        int N = 10;
        // Print 0 separately

        System.out.print("0 ");

        for (int i = 1; i <= 9; i++) {
            dfs(i, N);
        }

    }
    public static void dfs(int current, int N) {
        if (current > N) return;

        // Print current number
        System.out.print(current + " ");

        // Try appending digits 0–9
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next <= N) {
                dfs(next, N);
            } else {
                return; // no need to explore further (pruning)
            }
        }
    }
}
