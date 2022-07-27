#LEETCODE SOLUTION

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root: return
        
        start = curr = root
        while curr.left:
            curr.left.next = curr.right
            if curr.next:
                curr.right.next = curr.next.left
                curr = curr.next
            else:
                curr.next = None
                curr = start.left
                start = curr
                
        return root
      
 #PEPCODING SOLUTION     
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        black=root
        while black is not None and black.left is not None:
            n=black
            while True:
                n.left.next=n.right
                if n.next is None:
                    break
                n.right.next=n.next.left
                n=n.next
            black= black.left
        return root
        
