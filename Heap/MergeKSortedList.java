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
   
    public ListNode mergeKLists(ListNode[] lists) {
        // Initiate a minheap based on the val of the node
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // put the first node of every list into queue
        for (ListNode node : lists) {
            if (node == null) continue;
            queue.add(node);
        }
        
        // dummy head to carry the result
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        // link the root of minheap to he dummyHead, add the root.next to the minheap, repeate this process untill minheap runs out of nodes
        while(!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) queue.add(curr.next);
        }
        return dummyHead.next;
    }
}

//vs:https://www.youtube.com/watch?v=E5WSILx1q0Q
//ide : https://leetcode.com/problems/merge-k-sorted-lists/
//Time Complexity: O(nlogk) where n is the total number of nodes and k is the number of lists.
//Space Complexity: O(n) to create the new list (or O(1) extra space).
