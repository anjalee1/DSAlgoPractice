
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
    
    public ListNode reverse(ListNode head){
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode forw=null;
        
        while(curr != null){
            forw=curr.next;
            curr.next=prev;
            
            prev =curr;
            curr=forw; 
            
        }
        return prev;   
    }
                           
    
    public boolean isPalindrome(ListNode head) {  
        
         ListNode slow =head;
         ListNode fast =head;
         
         while(fast.next != null && fast.next.next != null){
             
             slow=slow.next;
             fast=fast.next.next;
             
         }
        
        slow.next=reverse(slow.next);
        slow=slow.next;
        ListNode dummy =head;
        
        while(slow!=null){
            
            if(dummy.val != slow.val){
                return false;
            }
            
            dummy=dummy.next;
            slow=slow.next;
        }
        
        return true;
        
    }
    
    
}

// video sol : https://www.youtube.com/watch?v=-DtNInqFUXs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=37
//ide :https://leetcode.com/problems/palindrome-linked-list/
// Time Complexity: O(N/2)+O(N/2)+O(N/2)
// Reason: O(N/2) for finding the middle element, reversing the list from the middle element, and traversing again to find palindrome respectively.
// Space Complexity: O(1)
// Reason: No extra data structures are used.
