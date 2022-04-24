def removeDuplicates(self):
        #write your code here
        node=self.head
        while node:
            if node.next:                      # check if theres a next node
                if node.data == node.next.data:  # check the current node val and next node val
                    node.next = node.next.next # "remove"/skip the next node since it has dupe val
                    continue                   # keep the node pointer at the current node
            node = node.next                   # no other dupes, move pointer to next node
        return self.head    
