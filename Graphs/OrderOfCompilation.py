
from collections import deque,defaultdict

def main():
    vtces = int(input())
    edges = int(input())
    graph = defaultdict(list)
    for i in range(edges):
        lines = input().split(" ")
        v1=int(lines[0])
        v2=int(lines[1])  
        graph[v1].append(v2)
        
     
    visited=[False]*vtces
    stack =deque()
    for v in range(vtces):
        if visited[v]==False:
            topologicalSort(graph,v,visited,stack)
            
    while len(stack)>0:
        print(stack.pop())


def topologicalSort(graph,src,visited,stack):
    visited[src]=True
    for nbr in graph[src]:
        if visited[nbr]==False:
            topologicalSort(graph,nbr,visited,stack)
    stack.append(src)

        
       
    



if __name__ == "__main__":
    main()
