def oddEven(self):
        #write your code here
        odd=LinkedList()
        even=LinkedList()
        while self.size>0:
            val=self.getFirst()
            self.removeFirst()
            if(val%2==0):
                even.addLast(val)
            else:
                odd.addLast(val)
        if(even.size>0 and odd.size>0):
           odd.tail.next=even.head
           self.head=odd.head
           self.tail=even.tail
           self.size=even.size+odd.size
        elif even.size>0:
           self.head=even.head
           self.tail=even.tail
           self.size=even.size
        
        elif odd.size>0:
           self.head=odd.head
           self.tail=odd.tail
           self.size=odd.size
