import java.util.PriorityQueue;

class Node {
    int value, arrayIndex, elementIndex;
    
    public Node(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}

public class MergeKSortedArrays {
    public static int[] mergeKSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) return new int[0];

        // Min-Heap to store (value, array index, element index)
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        int totalSize = 0;

        // Step 1: Insert the first element from each array into the heap
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new Node(arrays[i][0], i, 0));
                totalSize += arrays[i].length;
            }
        }

        int[] result = new int[totalSize];
        int index = 0;

        // Step 2: Process the heap
        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();  // Extract min element
            result[index++] = minNode.value;  // Add to result
            
            // Insert next element from the same array
            if (minNode.elementIndex + 1 < arrays[minNode.arrayIndex].length) {
                minHeap.add(new Node(arrays[minNode.arrayIndex][minNode.elementIndex + 1], minNode.arrayIndex, minNode.elementIndex + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] mergedArray = mergeKSortedArrays(arrays);
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
    }
}

