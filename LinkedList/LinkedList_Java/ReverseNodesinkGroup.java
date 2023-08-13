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
    public int lengthOfLinkedList(ListNode head){
        int length=0;
        while(head!=null){
            ++length;
            head=head.next;
        }
        
        return length;
    }
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null||head.next == null) return head;
    
        int length = lengthOfLinkedList(head);
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur;
        ListNode nex;
        
        
        while(length >= k) {
        cur = pre.next;
        nex = cur.next;
        for(int i=1;i<k;i++) {
            cur.next = nex.next;//intercahnging position with next
            nex.next = pre.next;//moving to front
            pre.next = nex; //setting nex next to dummy node
            nex = cur.next; //moving to next element for reverse 
        }
        pre = cur; //for next group curr will be pre
        length -= k;
     }
    return dummyHead.next;
    }
}

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// https://www.youtube.com/watch?v=Of0HPkk3JgI
