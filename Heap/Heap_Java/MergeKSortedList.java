//ide: https://leetcode.com/problems/merge-k-sorted-lists/
//sol: https://www.youtube.com/watch?v=E5WSILx1q0Q
https://chatgpt.com/g/g-2DQzU5UZl-code-copilot/c/6739ba5e-4acc-8004-981f-c07272d6e471

//Explanation of Complexity:

Time Complexity: O(n log k)
- We process all n nodes, and each insertion into the heap takes O(log k).
- Thus, the total time complexity is O(n log k).

Space Complexity: O(k)
- The priority queue stores up to k nodes at a time.
- Therefore, the space complexity is O(k).






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
        // Edge case: if the input array is empty or null
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap (PriorityQueue) to store nodes based on their values
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each linked list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        // Dummy node to help in forming the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the heap until it's empty
        while (!heap.isEmpty()) {
            // Extract the smallest node
            ListNode smallestNode = heap.poll();
            current.next = smallestNode;
            current = current.next;

            // If the extracted node has a next node, push it into the heap
            if (smallestNode.next != null) {
                heap.offer(smallestNode.next);
            }
        }

        // Return the head of the merged linked list
        return dummy.next;
    }
}
