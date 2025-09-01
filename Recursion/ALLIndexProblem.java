package Recursion;

import java.util.*;

public class ALLIndexProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int M = sc.nextInt();
        List<Integer> indices = findAllIndices(arr, M, 0);
        for (int idx : indices) {
            System.out.print(idx + " ");
        }
    }
    public static List<Integer> findAllIndices(int[] arr, int target, int index) {
        // base case
        if (index == arr.length) {
            return new ArrayList<>(); // empty list
        }
        
        // recursive call
        List<Integer> result = findAllIndices(arr, target, index + 1);
        
        // if current element matches, add at front
        if (arr[index] == target) {
            result.add(0, index);
        }
        
        return result;
    }
}
