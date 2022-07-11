import queue

class Edge:
    def __init__(self,src,nbr):
        self.src = src
        self.nbr = nbr

class pair:
    def __init__(self,src,psf):
        self.src=src
        self.psf=psf

def isCycle(graph,src,vis):
    q=queue.Queue()
    q.put(pair(src,str(str)))

    while q.qsize()>0:
        val=q.get()
        if vis[val.src] == True:
            return True
        vis[val.src] =True
        for e in graph[val.src]:
            if vis[e.nbr] == False:
                q.put(pair(e.nbr,val.psf+str(e.nbr)))
        return False
        



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
        e1 = Edge(v1 ,v2 )
        e2 = Edge(v2 ,v1 )
        graph[e1.src].append(e1)
        graph[e2.src].append(e2)
    
    vis = [False for i in range(vtces)]
    
    for i in range(vtces):
        if vis[i]==False:
            ans=isCycle(graph,i,vis)
            if ans==True:
                print("true")
                return
    
    print("false")
    

      
if __name__ == "__main__":
    main()
