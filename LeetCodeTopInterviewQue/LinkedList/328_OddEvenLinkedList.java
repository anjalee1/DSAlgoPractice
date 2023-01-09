//ide: https://leetcode.com/problems/odd-even-linked-list/
//sol: https://www.youtube.com/watch?v=YE9ggKeHeK0

//tc:o(n)
//sc:o(1)


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode odd = head;
        ListNode even =head.next;

        ListNode odd_head=head;
        ListNode even_head=head.next;

        while(even != null && even.next != null){
            odd.next =odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=even_head;
        return head;
    }
}
