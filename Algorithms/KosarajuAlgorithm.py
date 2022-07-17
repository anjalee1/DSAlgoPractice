from collections import defaultdict,deque

def randomDfs(graph,vis,vtx,stack):
    vis[vtx]=True
    for nbr in graph[vtx]:
        if not vis[nbr]:
            randomDfs(graph,vis,nbr,stack)
    stack.append(vtx)

def reverseGraph(graph,vtces):
    newGraph = defaultdict(list)
    for vt in range(1,vtces+1):
        for nbr in graph[vt]:
            newGraph[nbr].append(vt)
    return newGraph


def dfs(graph,vis,vtx):
    vis[vtx]=True
    for nbr in graph[vtx]:
        if not vis[nbr]:
            dfs(graph,vis,nbr)

def kosarajuAlgo(graph,vtces):
    stack=deque()
    vis=[False]*(vtces+1)
    for vtx in range(1,vtces+1):
        if not vis[vtx]:
            randomDfs(graph,vis,vtx,stack)
    ngraph=reverseGraph(graph,vtces)
    ans=0
    vis=[False]*(vtces+1)
    while len(stack)>0:
        rem=stack.pop()
        if not vis[rem]:
                dfs(ngraph,vis,rem)
                ans=ans+1  
    
    return ans

def main():
    vtces,edges = input().split(" ")
    graph = defaultdict(list)
    for i in range(int(edges)):
        lines = input().split(" ")
        v1=int(lines[0])
        v2=int(lines[1])  
        graph[v1].append(v2)

    print(kosarajuAlgo(graph,int(vtces)))
     

if __name__ == "__main__":
    main()
