
//ide: https://leetcode.com/problems/swap-nodes-in-pairs/description/
//sol: SOLVED BY ME :)
//TC:O(N)
//SC:O(1)

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head ==null|| head.next ==null){
            return head;
        }
        ListNode dummy =new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr =head;
        ListNode nex;

        while(curr != null && curr.next !=null){
             nex=curr.next;
             prev.next=nex;
             curr.next=nex.next;
             nex.next=curr;;
             prev=curr;
             curr=curr.next;
        }

        return dummy.next;
    }
}
