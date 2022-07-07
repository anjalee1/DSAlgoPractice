class Edge:
    def __init__(self, src, nbr, wt):
        self.src = src
        self.nbr = nbr
        self.wt = wt


def getCmp(graph, vis, src, comp):
    vis[src] = True
    comp.append(src)
    for ed in graph[src]:
        if(vis[ed.nbr] == False):
            getCmp(graph, vis, ed.nbr, comp)


def main():
    vtces = int(input())
    edges = int(input())
    graph = {}
    for i in range(vtces):
        graph[i] = []

    for i in range(edges):
        values = input().split(" ")
        e1 = Edge(int(values[0]), int(values[1]), int(values[2]))
        e2 = Edge(int(values[1]), int(values[0]), int(values[2]))
        graph[e1.src].append(e1)
        graph[e2.src].append(e2)

    comps = []
    # write your code here
    vis = [False for i in range(vtces)]

    count = 0
    for i in range(vtces):
        if(vis[i] == False):
            comp = []
            getCmp(graph, vis, i, comp)
            count = count + 1
            comps.append(comp)

    print(comps)


if __name__ == "__main__":
    main()
