//ide: https://leetcode.com/problems/rotate-list/
//video sol: https://www.youtube.com/watch?v=9VPm6nEbVPA
//Time Complexity: O(length of list) + O(length of list – (length of list%k))
//Reason: O(length of the list) for calculating the length of the list. O(length of the list – (length of list%k)) for breaking link.
//Space Complexity: O(1)
//Reason: No extra data structure is used for computation.



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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next ==null || k==0){
            return head;
        }
        ListNode temp=head;
        int length =1;
        
        while(temp.next !=null){
            ++length;
            temp=temp.next;
        }
        
        temp.next =head;
        
        k=k%length;
        int end =length-k; 
        while(end--!=0) temp = temp.next;
        
        head=temp.next;
        temp.next=null;
        
        return head;
        
        
    }
}
