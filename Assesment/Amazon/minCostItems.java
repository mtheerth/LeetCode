/*Given a set of variables on items in a store, find the minimum cost to grab m items from the store.
The quanity of each item is infinite and
Cost of an item is given by the formula cost[i] = a[i] + (j-1)*b[i];
1<=j<=n where j is the cnt of that distinct item.
NOTE : Here cost changes if same item is picked up again.

a is a list of size n
b is a list of size n
m is a number with bound till 10^5
in java
*/

import java.util.*;

public class MinCostStoreItems {

    static class Item implements Comparable<Item> {
        long cost;
        int itemIndex;
        int count;

        Item(long cost, int itemIndex, int count) {
            this.cost = cost;
            this.itemIndex = itemIndex;
            this.count = count;
        }

        @Override
        public int compareTo(Item other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public static long minTotalCost(int[] a, int[] b, int m) {
        int n = a.length;
        PriorityQueue<Item> minHeap = new PriorityQueue<>();

        // Initialize heap with 1st copy of each item
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Item(a[i], i, 1));
        }

        long totalCost = 0;

        for (int i = 0; i < m; i++) {
            Item current = minHeap.poll();
            totalCost += current.cost;

            // Insert next copy of the same item
            int nextCount = current.count + 1;
            long nextCost = (long) a[current.itemIndex] + (long)(nextCount - 1) * b[current.itemIndex];
            minHeap.offer(new Item(nextCost, current.itemIndex, nextCount));
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] a = {3, 2}; // base cost
        int[] b = {1, 2}; // incremental cost
        int m = 4;
        System.out.println("Minimum total cost to buy " + m + " items: " + minTotalCost(a, b, m));
    }
}

