package practise.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class OverlappingIntervals {
	
	public static void main(String args[]) {
		
		int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};

		 Arrays.sort(intervals, (a, b)->Integer.compare(a[1], b[1]));
		 //[1, 2][2, 3][1, 3][3, 4]
	        int end = intervals[0][1];
	        int count = 0;
	       // int count = intervals.length-1;
	        for(int i=1; i < intervals.length; i++){
	            if( intervals[i][0]>=end ){
	                end = intervals[i][1];
	                //count--;
	            } else {
	            	count++;
	            }
	        }
	        System.out.println( count);
	}
}

