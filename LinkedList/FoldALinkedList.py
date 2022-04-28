def foldHelper(self,right,floor):

      if  right is None:
        return
      
      self.foldHelper(right.next,floor+1)
      if floor>self.size//2:
        temp=self.left2.next
        self.left2.next=right
        right.next=temp
        self.left2=temp
      elif floor==self.size//2:
        tail=right
        tail.next=None

    left2=None 
    def fold(self):
        self.left2=self.head
        self.foldHelper(self.head,0)
        # write your code here
