/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
         if (head == null) {
            return null;
        }

        // Step 1: Create a mapping of original nodes to their copies
        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        while (current != null) {
            map.put(current, new Node(current.val)); // Create a copy of the current node
            current = current.next;
        }

        // Step 2: Set the next and random pointers for the copied nodes
        current = head;
        while (current != null) {
            Node copyNode = map.get(current);
            copyNode.next = map.get(current.next); // Set next pointer
            copyNode.random = map.get(current.random); // Set random pointer
            current = current.next;
        }

        // Return the head of the copied list
        return map.get(head);
        
    }
}
