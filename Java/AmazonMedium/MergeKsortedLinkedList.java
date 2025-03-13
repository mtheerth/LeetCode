import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap (Priority Queue) to store ListNodes sorted by value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add all list heads to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Step 2: Dummy node to help in constructing the result list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 3: Process the heap
        while (!minHeap.isEmpty()) {
            // Extract the smallest node
            ListNode minNode = minHeap.poll();
            tail.next = minNode;  // Attach to the result list
            tail = tail.next;  // Move tail pointer
            
            // Insert the next node of the extracted list into the heap
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        return dummy.next;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        
        // Example input: [[1->4->5], [1->3->4], [2->6]]
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // Merge and print result
        ListNode mergedHead = solution.mergeKLists(lists);
        printList(mergedHead);
    }
}

