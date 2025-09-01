import java.util.*;
public class NGER2 {
    
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); 
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) stack.push(i);
            }

        return result;
    }
    public static void main(String[] args) {
        NGER2 obj = new NGER2();
        int[] nums = {1, 2, 1};
        int[] result = obj.nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
