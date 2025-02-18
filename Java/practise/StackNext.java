package my.test;

import java.util.*;

public class StackNext {
	    public static int[] nextGreaterElements(int[] nums) {
	        int n = nums.length;
	        int[] result = new int[n];
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < n; i++) {
	            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
	                result[stack.pop()] = nums[i];
	            }
	            stack.push(i);
	        }
	        // Fill in -1 for elements with no next greater element
	        while (!stack.isEmpty()) {
	            result[stack.pop()] = -1;
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        int[] nums = {2, 1, 2, 4, 3};
	        int[] result = nextGreaterElements(nums);
	        for (int num : result) {
	            System.out.print(num + " "); // Outputs: 4 2 4 -1 -1 
	        }
	    }
	}
