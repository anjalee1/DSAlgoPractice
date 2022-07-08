
from collections import defaultdict

class Edge:
    def __init__(self, src, nbr):
        self.src = src
        self.nbr = nbr

def hamiltonianPathAndCycle(graph, osrc, src, visited, psf):
    if len(visited)==len(graph)-1:
        print(psf,end='')

        closingEdge = False
        for edge in graph[osrc]:
          if edge.nbr == src:
            closingEdge = True;
            break
            
        if closingEdge:
            print("*")
        else :
            print(".")

        return


    visited.add(src)
    for edge in graph[src]:
        if edge.nbr not in visited:
            hamiltonianPathAndCycle(graph, osrc, edge.nbr, visited, psf + edge.nbr)

    visited.remove(src)



def main():
    vtces = int(input())
    edges = int(input())
    graph=defaultdict(list)
    
    for i in range(edges):
        values = input().split(" ")
        e1 = Edge(values[0], values[1])
        e2 = Edge(values[1], values[0])
        graph[e1.src].append(e1)
        graph[e2.src].append(e2)

    src=input()
    visited=set()
    hamiltonianPathAndCycle(graph, src, src, visited, src + "")



if __name__ == "__main__":
    main()
