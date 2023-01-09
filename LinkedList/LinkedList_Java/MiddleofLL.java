
//ide: https://leetcode.com/problems/middle-of-the-linked-list/
//sol:https://www.youtube.com/watch?v=sGdwSH8RK-o&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=29
//https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/
//tc: o(n/2)
//sc:o(1)

//fast.next!=null  => for odd
//fast != null for even and when second node of two mid is required
//fast.next.next != null for even and when first node of two mid is required
class Solution {
    public ListNode middleNode(ListNode head) {
        
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next != null){
              slow =slow.next;
              fast=fast.next.next;
        }
        
        if(fast.next == null){
            return slow;
        }
        else{
            return slow.next;
        }
        
    }
}
