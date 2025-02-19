import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // left half (smaller numbers)
    private PriorityQueue<Integer> minHeap; // right half (larger numbers)

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        minHeap = new PriorityQueue<>(); // Min Heap (default is min heap)
    }

    public void addNum(int num) {
        // Add to maxHeap first
        maxHeap.offer(num);

        // Balance: maxHeap's top should not be greater than minHeap's top
        if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        // Maintain size property
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // Even case
        } else {
            return maxHeap.peek(); // Odd case
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // Output: 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // Output: 2
    }
}

