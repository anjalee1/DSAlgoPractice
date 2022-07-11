import queue
class Edge:
    def __init__(self,src,nbr,wt):
        self.src = src
        self.nbr = nbr
        self.wt=wt

class pair:
    def __init__(self,v,tm):
        self.v =v
        self.tm = tm



def main():
    vtces = int(input())
    edges = int(input()) 
    graph = {}
    for i in range(vtces):
        graph[i] = []
    
    for i in range(edges): 
        lines = input().split(" ")
        v1=int(lines[0])
        v2=int(lines[1])
        wt=int(lines[2])
        e1 = Edge(v1 ,v2 ,wt)
        e2 = Edge(v2 ,v1 ,wt)
        graph[e1.src].append(e1)
        graph[e2.src].append(e2) 
        
    src = int(input())    
    t = int(input())
    count=0  
    visited=[0]*vtces
    q=queue.Queue()
    q.put(pair(src,1))
    while q.qsize()>0:
        p=q.get()
        if p.tm>t:
            break
        if visited[p.v]>0:
            continue
        visited[p.v]=p.tm
        count=count+1
        for e in graph[p.v]:
            if visited[e.nbr]==0:
                q.put(pair(e.nbr,p.tm+1))
    print(count)


   
      
if __name__ == "__main__":
    main()
