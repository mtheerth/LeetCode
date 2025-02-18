package practise.leetcode;

import java.util.*;

public class MinBurst {
	    //findMinArrowShots {
	public static void main(String args[]) {
		    int[][] points = {{1,2},{2,3},{3,4},{4,5}};
		
	        int result = 1;
	        //code
	        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));
	        int end = points[0][1];
	        for (int i =1; i < points.length; i++){
	            if (points[i][0] > end){
	                result++;
	                end = points[i][1];
	            }
	        }
	        System.out.println(result); ;
	    }
	    
}

