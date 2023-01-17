//ide:https://leetcode.com/problems/sort-list/
//sol:https://www.youtube.com/watch?v=HUFibUCDt0U

//tc:nlogn
//sc:logn for explaination look notebook


class Solution {

    public ListNode getMiddle(ListNode node){
     if(node==null || node.next==null) return node;
      ListNode slow=node;
      ListNode fast =node;
      while(fast.next!=null && fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
      }
      return slow;
    }

    public ListNode mergeSortedList(ListNode node1,ListNode node2){
      if(node1==null || node2==null) return node1!= null?node1:node2;
      ListNode l1=node1;
      ListNode l2=node2;
      ListNode dummy = new ListNode(0);
      ListNode temp =dummy;
      while(l1!=null && l2!=null){
           if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
               temp.next=l2;
               l2=l2.next; 
            }
            temp=temp.next;  
        }
        temp.next = l1!= null ?l1:l2;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next ==null) return head; //head==null when empty list and head.next==null when one node is remaining

        ListNode mid=getMiddle(head);
        ListNode nHead =mid.next;
        mid.next=null;

        ListNode head1= sortList(head);
        ListNode head2= sortList(nHead);

        return mergeSortedList(head1,head2);
    }
}
