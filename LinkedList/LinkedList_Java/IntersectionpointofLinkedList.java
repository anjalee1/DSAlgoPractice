//Method 1-difference method
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode A=headA;
        ListNode B=headB;
        int lA=length(headA);
        int lB=length(headB);
        
        while (lA>lB){
            A=A.next;
           lA--;
        }
        
         while (lB>lA){
            B=B.next;
           lB--;
        }
        
         while (A!=B){
            A=A.next;
            B=B.next;
        }
        
        return A;
      
        
    }
    
    
    public int length(ListNode head){
        int length =0;
        ListNode node=head;
        while(node!=null){
            node =node.next;
            length++;
            
        }
        
        return length;
    }
}

// Time Complexity:

// O(2max(length of list1,length of list2))+O(abs(length of list1-length of list2))+O(min(length of list1,length of list2))

// Reason: Finding the length of both lists takes max(length of list1, length of list2) because it is found simultaneously for both of them. Moving the head pointer ahead by a difference of them. The next one is for searching.

// Space Complexity: O(1)

// Reason: No extra space is used.


//Method 2


