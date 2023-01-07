//ide:https://leetcode.com/problems/intersection-of-two-linked-lists/description/
//sol:https://www.youtube.com/watch?v=u4FWXfgS8jw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=36
//https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/

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

//method-1  ---BruteForce 
//tc:o(m*n)
//sc:o(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if(headA ==null || headB ==null) return null;
       while(headA != null){
            ListNode temp = headB;
            while (temp!=null){
                if(headA==temp){
                    return headA;
                }
                temp= temp.next;
            }
            headA=headA.next;
       }  
       return null;
      
 }
}

//notes:
//headB is stored in temp but headA is not because headA is being iterated only once but headB is being iterated 
//again and again and not storing in temp will change the original value 

//Method 2 : Hashing

//tc: o(m+n)
//sc:o(m)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if(headA ==null || headB ==null) return null;
        HashSet<ListNode> set = new HashSet<>();

        while(headA != null){
            set.add(headA);  
            headA=headA.next;
       }

       while(headB!=null){
           if(set.contains(headB)){
               return headB;
           }
           headB=headB.next;

       }

       return null;
    }
}


//Method 3-difference method

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


//Method 4
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode d1 = headA;
        ListNode d2 = headB;

        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next;
            d2 = d2 == null? headA:d2.next;
        }

        return d1;
 }
}

//tc and sc are same as third method

