package Recursion;

public class LastIndex {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 2, 5, 2};
        int target = 2;
        int lastIndex = findLastIndex(arr, target, arr.length - 1);
        System.out.println("Last index of " + target + " is: " + lastIndex);
    }
    public static int findLastIndex(int[] arr, int target, int index) {
        if (index < 0) {
            return -1; // Base case: target not found
        }
        if (arr[index] == target) {
            return index; // Target found at current index
        }
        return findLastIndex(arr, target, index - 1); // Recur for the previous index
    }
}
