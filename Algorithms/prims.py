from collections import defaultdict
from queue import PriorityQueue

class Graph:
    def __init__(self):
        self.graph =defaultdict(list)

    def addEdge(self,u,v,w):
        self.graph[u].append((v,w))

    def getGraph(self):
        return self.graph

def prims(graph):
    n=len(graph)
    visited=[False for i in range(n)]
    q = PriorityQueue()
    q.put((0,-1,0))
    while q.qsize() > 0:
      wt,u,v = q.get()
      if visited[v]:
         continue
      visited[v] = True
      if u != -1:
          print(v, "-", u, "\t", wt)
      for vnext, wt in graph[v]:
          if visited[vnext] == False:
              q.put((wt,v,vnext))




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


graph=g.getGraph()
print(graph)
prims(graph)



