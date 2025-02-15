package practise.leetcode;

import java.util.*;

public class LIS {

	    public int lengthOfLIS(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;

	        int n = nums.length;
	        int[] dp = new int[n];
	        int maxLIS = 1;
	        
	        Arrays.fill(dp, 1);

	        for (int i = 1; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                if (nums[j] < nums[i]) {
	                   // System.out.println(Arrays.toString(dp));
	                    dp[i] = Math.max(dp[i], dp[j] + 1);
	                    System.out.println(Arrays.toString(dp));
	                }
	            }
	            maxLIS = Math.max(maxLIS, dp[i]);
	        }

	        return maxLIS;
	    }

	    public static void main(String[] args) {
	        LIS lis = new LIS();
	        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
	        System.out.println("Length of LIS: " + lis.lengthOfLIS(nums)); // Output: 4
	    }
	}


