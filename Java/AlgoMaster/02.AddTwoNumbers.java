/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int prev = 0;
        int sum =0;
        ListNode dummyNode = new ListNode(0);
        ListNode dummy = dummyNode;
        while ((l1 != null)  || (l2 != null) || prev !=0){
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + prev;
            dummy.next = new ListNode(sum % 10) ;
            dummy = dummy.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
            prev = sum >= 10 ? sum / 10 : 0 ;
        }
        return dummyNode.next;
    }
}
