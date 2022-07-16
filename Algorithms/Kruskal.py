
def KruskalAlgo(vtces, Edges):
    srtEdges=sorted(Edges, key=lambda x: x[2])
    ans = 0
    for i in range(len(srtEdges)):
        u = srtEdges[i][0]
        v = srtEdges[i][1]
        wt = srtEdges[i][2]
        merged = union(u, v)
        if merged == True:
            ans += wt
    return ans


def find(vt):
    if parent[vt] == vt:
        return vt
    temp = find(parent[vt])
    parent[vt] = temp
    return temp


def union(u, v):
    lu = find(u)
    lv = find(v)
    if lu == lv:
        return False
    else:
        if rank[lu] > rank[lv]:
            parent[lv] = lu;
        elif rank[lu] < rank[lv]:
            parent[lu] = lv;
        else:
            parent[lu] = lv;
            rank[lv] = rank[lv] + 1
        return True


vtces = int(input())
Noofedges = int(input())
parent = [0] * vtces
rank = [1] * vtces
Edges = []
for i in range(Noofedges):
    lines = input().split(" ")
    u = int(lines[0])
    v = int(lines[1])
    wt = int(lines[2])
    Edges.append((u, v, wt))
parent = [0] * vtces
rank = [1] * vtces
for i in range(vtces):
    parent[i] = i
mincost = KruskalAlgo(vtces, Edges)
print(mincost)


