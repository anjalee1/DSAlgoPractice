from collections import defaultdict

class Edge:
    def __init__(self, src, nbr):
        self.src = src
        self.nbr = nbr



def getCmp(graph, vis, src, comp):
    vis[src] = True
    comp.append(src)
    for ed in graph[src]:
        if(vis[ed.nbr] == False):
            getCmp(graph, vis, ed.nbr, comp)
def main():
    n = int(input())
    k = int(input())
    graph=defaultdict(list)
    #write your code here
    for i in range(k):
        values = input().split(" ")
        e1 = Edge(int(values[0]), int(values[1]))
        e2 = Edge(int(values[1]), int(values[0]))
        graph[e1.src].append(e1)
        graph[e2.src].append(e2)

    comps = []
    vis = [False for i in range(n)]
    for i in range(n):
        if(vis[i] == False):
            comp = []
            getCmp(graph, vis, i, comp)
            comps.append(comp)
    pairs=0
    for i in range(len(comps)):
        for j in range(i+1,len(comps)):
            count=len(comps[i])*len(comps[j])
            pairs=pairs+count
    print(pairs)



if __name__ == "__main__":
    main()
