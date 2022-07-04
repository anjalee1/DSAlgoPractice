#Time complexity: https://www.youtube.com/watch?v=_0s2e5SqhSk
#explanation : https://www.youtube.com/watch?v=sD0lLYlGCJE
>>> (1, {'alpha': 1}) < (2, {'beta': 2})
True

# Now it pays to look at how Python compares tuples. First, Python compares the first entries of each tuple. In this case, 1 < 2, and Python returns True. 
# But if the first entries are not ordered -- say they are the same -- Python then goes to comparing the second entries. For instance
#code

from collections import defaultdict
from queue import PriorityQueue
from math import inf

class Graph:
    def __init__(self):
        self.graph =defaultdict(list)

    def addEdge(self,u,v,w):
        self.graph[u].append((v,w))

    def getGraph(self):
        return self.graph

def dikstra(graph, root):
    n=len(graph)
    visited=[False for i in range(n)]
    dist=[inf for i in range(n)]
    dist[0]=0
    q = PriorityQueue()
    q.put((0,dist[0]))
    while q.qsize() > 0:
      u,di = q.get()
      if visited[u]:
         continue
      visited[u] = True
      print(f'{u} --> {dist[u]}')
      for v, d in graph[u]:
          if visited[v] == False and dist[v]>dist[u]+d:
              dist[v]=dist[u]+d
              q.put((v,dist[v]))
    return dist


g=Graph()
g.addEdge(0,1,10)
g.addEdge(1,0,10)
g.addEdge(1,2,10)
g.addEdge(2,1,10)
g.addEdge(2,3,10)
g.addEdge(3,2,10)
g.addEdge(0,3,40)
g.addEdge(3,0,40)
g.addEdge(4,3,2)
g.addEdge(3,4,2)
g.addEdge(4,5,3)
g.addEdge(5,4,3)
g.addEdge(5,6,3)
g.addEdge(6,5,3)
g.addEdge(4,6,8)
g.addEdge(6,4,8)
g.addEdge(2,5,5)
g.addEdge(5,2,5)


graph=g.getGraph()
print(graph)

sps=dikstra(graph,0)
print(sps)


