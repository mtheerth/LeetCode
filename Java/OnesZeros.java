package practise.leetcode;

import java.util.*;

public class OnesZeros {
	    public static int findMaxForm(String[] S, int M, int N) {
	    	//return helper(S,0,M,N);
	    	return DP(S,M,N);
	    	
	    	
	    }
	    private static int DP(String[] S, int M, int N) {
	        int[][] dp = new int[M+1][N+1];
	        for (String str : S) {
	            int zeros = 0, ones = 0;
	            for (char c : str.toCharArray())
	                if (c == '0') zeros++;
	                else ones++;
	            for (int i = M; i >= zeros; i--)
	                for (int j = N; j >= ones; j--) {
	                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
	                }
	        }
	        
	        return dp[M][N];
	    }
	    private static int helper(String[] strs, int index, int zeros, int ones) {
	        if (index == strs.length || (zeros == 0 && ones == 0)) {
	            return 0;
	        }
	        
	        // Count zeros and ones in the current string
	        int[] count = countZerosOnes(strs[index]);
	        
	        // Decision 1: Include the current string
	        int include = 0;
	        if (zeros >= count[0] && ones >= count[1]) { // 5
	            include = 1 + helper(strs, index + 1, zeros - count[0], ones - count[1]);
	        }
	        
	        // Decision 2: Exclude the current string
	        int exclude = helper(strs, index + 1, zeros, ones);

	        
	        // Return the maximum of including or excluding
	        return Math.max(include, exclude); // return max 1.
	    }
	    
	    private static int[] countZerosOnes(String s) {
	        int[] count = new int[2];
	        for (char c : s.toCharArray()) {
	            count[c - '0']++;
	        }
	        return count;
	    }
	    public static void main (String args[]) {
	    	String [] S= {"000000000000000000001111111111111","10","0001","111001","1","0"};
	    	int M = 5;
	    	int N=3;
	    	
	    	System.out.print(findMaxForm(S, M, N));
	    }
	}

