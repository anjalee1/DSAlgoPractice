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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow =dummy;
       
        for(int i=1 ;i<=n ;i++){
            fast =fast.next;
        }

        while(fast.next != null){
            fast =fast.next;
            slow = slow.next;
        }

        slow.next =slow.next.next;
        return dummy.next;

        
    }
}
//TC-O(N)
//SC-O(1)
// vidoe solution : https://www.youtube.com/watch?v=Lhu3MsXZy-Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=31
//ide : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
