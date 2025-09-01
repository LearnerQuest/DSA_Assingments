package Recursion;

public class FirstIndex {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 2, 5, 2};
        int target = 2;
        int firstIndex = findFirstIndex(arr, target, 0);
        System.out.println("First index of " + target + " is: " + firstIndex);
    }
    public static int findFirstIndex(int[] arr, int target, int index) {
        if (index >= arr.length) {
            return -1; // Base case: target not found
        }
        if (arr[index] == target) {
            return index; // Target found at current index
        }
        return findFirstIndex(arr, target, index + 1); // Recur for the next index
    }
}
