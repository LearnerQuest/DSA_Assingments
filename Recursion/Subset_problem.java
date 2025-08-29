package Recursion;
import java.util.*;
public class Subset_problem {
    static void printSubsets(int[] arr, int idx, int target, List<Integer> current) {
        if (idx == arr.length) {
            if (target == 0) {
                // Print current subset
                for (int x : current) {
                    System.out.print(x + " ");
                }
                System.out.print(" "); // 2 spaces handled in main after printing all subsets
            }
            return;
        }

        // Include current element
        current.add(arr[idx]);
        printSubsets(arr, idx + 1, target - arr[idx], current);

        // Exclude current element
        current.remove(current.size() - 1);
        printSubsets(arr, idx + 1, target, current);
    }

    // b. Function to count subsets
    static int countSubsets(int[] arr, int idx, int target) {
        if (idx == arr.length) {
            return (target == 0) ? 1 : 0;
        }

        // Include current element
        int include = countSubsets(arr, idx + 1, target - arr[idx]);

        // Exclude current element
        int exclude = countSubsets(arr, idx + 1, target);

        return include + exclude;
    }
    public static void main(String args[]) {
        // Your Code Here
         Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        // a. Print subsets
        printSubsets(arr, 0, target, new ArrayList<>());
        System.out.println(); // New line

        // b. Print count
        System.out.println(countSubsets(arr, 0, target));
    }
}
