
import queue
from collections import defaultdict

def main():
    vtces = int(input())
    edges = int(input())
    graph = defaultdict(list)
    for i in range(edges):
        lines = input().split(" ")
        v1=int(lines[0])
        v2=int(lines[1])  
        graph[v1].append(v2)
        graph[v2].append(v1)
     
    visited=[-1]*vtces
    for v in range(vtces):
        if visited[v]==-1:
            isCompBipartite=CheckIfComponentBipartite(graph,v,visited)
            if isCompBipartite==False:
                print("false")
                return
    print("true")


def CheckIfComponentBipartite(graph,src,visited):
    q=queue.Queue()
    q.put((src,str(src),0))
    while q.qsize()>0:
        v,psf,level =q.get()
        if visited[v]!=-1:
            if level!=visited[v]:
                return False
        else:
           visited[v]=level

        for nbr in graph[v]:
            if visited[nbr]==-1:
                q.put((nbr,psf+str(nbr),level+1))
        
    return True
        
       
    



if __name__ == "__main__":
    main()
