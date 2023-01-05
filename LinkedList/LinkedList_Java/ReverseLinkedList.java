//ide: https://leetcode.com/problems/reverse-linked-list/
//sol:https://www.youtube.com/watch?v=iRtLEoL-r-g&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=27
//https://takeuforward.org/data-structure/reverse-a-linked-list/



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
    public ListNode reverseList(ListNode head) {
        if(head==null ||  head.next==null){
            return head;
        }
        ListNode prev =null;
        ListNode curr =head;
        ListNode forw =null;
        while(curr!=null){
            forw=curr.next;
            
            curr.next=prev;
            
            prev=curr;
            curr=forw;
        }
        
        return prev;
        
    }
}
