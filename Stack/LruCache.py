https://www.youtube.com/watch?v=JxtmaAFfVBo
https://leetcode.com/problems/lru-cache/submissions/class Node:

    def __init__(self):
        self.key = None
        self.value = None
        self.next = None
        self.prev = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache=dict()
        self.capacity=capacity
        self.head=Node()
        self.tail=Node()
        self.head.next=self.tail
        self.tail.prev=self.head

    def addNode(self,node):
        nbr=self.head.next
        node.next=nbr
        node.prev=self.head
        nbr.prev=node
        self.head.next=node
        
    def removeNode(self,node):
        prevnbr=node.prev
        nextnbr=node.next
        
        prevnbr.next=nextnbr
        nextnbr.prev=prevnbr
        node.prev=node.next=None
        
    def moveToFront(self,node):
        self.removeNode(node)
        self.addNode(node)
           
    def get(self, key: int) -> int:
        node=self.cache.get(key)
        if node is None:
            return -1
        else:
            value=node.value
            self.moveToFront(node)
            return value
        
    def put(self, key: int, value: int) -> None:
        node=self.cache.get(key)
        if node is None:
            newNode=Node()
            newNode.key=key
            newNode.value=value
            if len(self.cache)==self.capacity:
                lruNode=self.tail.prev
                self.cache.pop(lruNode.key)
                self.removeNode(lruNode)
            self.cache[key]=newNode
            self.addNode(newNode)
            
        else:
            node.value=value
            self.moveToFront(node)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
  class Node:

    def __init__(self):
        self.key = None
        self.value = None
        self.next = None
        self.prev = None

class LRUCache:

    def __init__(self, capacity: int):
        self.cache=dict()
        self.capacity=capacity
        self.head=Node()
        self.tail=Node()
        self.head.next=self.tail
        self.tail.prev=self.head

    def addNode(self,node):
        nbr=self.head.next
        node.next=nbr
        node.prev=self.head
        nbr.prev=node
        self.head.next=node
        
    def removeNode(self,node):
        prevnbr=node.prev
        nextnbr=node.next
        
        prevnbr.next=nextnbr
        nextnbr.prev=prevnbr
        node.prev=node.next=None
        
    def moveToFront(self,node):
        self.removeNode(node)
        self.addNode(node)
           
    def get(self, key: int) -> int:
        node=self.cache.get(key)
        if node is None:
            return -1
        else:
            value=node.value
            self.moveToFront(node)
            return value
        
    def put(self, key: int, value: int) -> None:
        node=self.cache.get(key)
        if node is None:
            newNode=Node()
            newNode.key=key
            newNode.value=value
            if len(self.cache)==self.capacity:
                lruNode=self.tail.prev
                self.cache.pop(lruNode.key)
                self.removeNode(lruNode)
            self.cache[key]=newNode
            self.addNode(newNode)
            
        else:
            node.value=value
            self.moveToFront(node)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
  
