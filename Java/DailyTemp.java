package practise.leetcode;

import java.util.*;

public class DailyTemp {
	public static void main (String args[]) {
		    int[] temperatures = {73,74,75,71,69,72,76,73};
	        int [] output = new int[temperatures.length];
	        Stack<Integer> st = new Stack<>();
	        for (int i=0 ; i < temperatures.length; i++){
	            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i] ){
	                int idx = st.pop();
	              output[idx] =  i - idx;
	            }
	            st.push(i);
	        }
	        System.out.println(Arrays.toString(output));
	    }

}

