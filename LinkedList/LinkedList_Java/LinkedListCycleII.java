//intution by gfg: https://www.geeksforgeeks.org/find-first-node-of-loop-in-a-linked-list/
//ide: https://leetcode.com/problems/linked-list-cycle-ii/

//video sol: https://www.youtube.com/watch?v=QfbOhn0WZ88&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44

//https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/

//Time Complexity: O(N)

//Reason: We can take overall iterations and club them to O(N)

//Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        ListNode entry = head;

        while(fast.next != null&&fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }
}
