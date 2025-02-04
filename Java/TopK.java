package my.test;

//
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

	public class TopK {
	    public static void main(String[] args) {
	        int[] nums = {3, 1, 5, 12, 2, 11};
	        int k = 3;

	        int[] topK = getTopKElements(nums, k);
	        System.out.println(Arrays.toString(topK)); // Output: [5,11,12]
	    }

	    public static int[] getTopKElements(int[] nums, int k) {
	        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
	    	//for 3 2 1
	    	PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
	        for (int num : nums) {
	            minHeap.offer(num); // Add the current number
	            if (minHeap.size() > k) {
	                minHeap.poll(); // Remove the smallest number
	            }
	        }

	        int[] topK = new int[k];
	        for (int i = 0; i < k; i++) {
	            topK[i] = minHeap.poll(); // Extract the top K elements
	        }

	        return topK;
	    }
	}


//}

