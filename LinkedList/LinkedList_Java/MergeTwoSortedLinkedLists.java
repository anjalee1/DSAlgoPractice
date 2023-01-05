
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null || list2==null) return list1!= null?list1:list2;
        
        ListNode dummyNode= new ListNode(-1);
        ListNode prev =dummyNode;
        ListNode c1= list1;
        ListNode c2= list2;
        
        while(c1 != null && c2!= null){ //while loop tc =o(m+n)
            if(c1.val<c2.val){
                prev.next=c1;
                c1=c1.next;
            }
            else{
               prev.next=c2;
                c2=c2.next; 
            }
            prev=prev.next;
            
        }
        
        prev.next = c1!= null ?c1:c2;//o(1)
        
        return dummyNode.next;
    }
}

//tc: o(m+n)
//Space Complexity :We are using the same lists just changing links to create our desired list. So no extra space is used. Hence, its space complexity is O(1). 
// leetcode link:https://leetcode.com/problems/merge-two-sorted-lists/ 
//solution video : https://www.youtube.com/watch?v=mBUcaPvEawI&t=3s
