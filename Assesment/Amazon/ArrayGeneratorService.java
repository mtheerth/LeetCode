/*An array arr of positive integers.

A state string of the same length as arr, where:

'1' means the corresponding arr[i] is available for selection.

'0' means arr[i] is initially blocked.

An integer m representing the number of operations to perform.

Operations:

Select: Choose any available arr[i] (where state[i] == '1'). You can choose the same element multiple times.

Append: Add the selected arr[i] to the sequence S.

Update State: After selection, any blocked element (state[i] == '0') that is adjacent to an available element (state[i-1] == '1') becomes available (state[i] is set to '1').
&*/


import java.util.PriorityQueue;

public class ArrayGeneratorService {
    public static int[] generateSequence(int[] arr, String state, int m) {
        int n = arr.length;
        // Max-heap is simulated using a priority queue with negative values
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        char[] stateChars = state.toCharArray();
        
        // Initialize the heap with available elements
        for (int i = 0; i < n; i++) {
            if (stateChars[i] == '1') {
                maxHeap.offer(new int[]{arr[i], i});
            }
        }
        
        int[] S = new int[m];
        int index = 0;
        
        for (int op = 0; op < m && !maxHeap.isEmpty(); op++) {
            int[] current = maxHeap.peek();
            int val = current[0];
            int i = current[1];
            S[index++] = val;
            
            // Check the right neighbor
            if (i + 1 < n && stateChars[i + 1] == '0') {
                stateChars[i + 1] = '1';
                maxHeap.offer(new int[]{arr[i + 1], i + 1});
            }
        }
        
        // In case m is larger than the number of available elements, but problem says m is valid
        return S;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 1};
        String state = "110";
        int m = 3;
        int[] result = generateSequence(arr, state, m);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output should be 5 5 5
    }
}
