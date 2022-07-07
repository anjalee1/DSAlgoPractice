from collections import deque
class StockSpanner:

    def __init__(self):
        self.stack=deque()

    def next(self, price: int) -> int:
        count=1
        while len(self.stack)>0 and self.stack[-1][0]<=price:
            count=count+self.stack[-1][1]
            self.stack.pop()
        self.stack.append((price,count))
        return self.stack[-1][1]
        
