def kthFromLast(self, k):
        # write your code here
        slow=self.head
        fast=self.head
        i=0
        while i<k:
            fast=fast.next
            i=i+1
        while fast!=self.tail:
            slow=slow.next
            fast=fast.next
        return slow.data
