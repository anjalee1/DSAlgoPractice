from collections import defaultdict
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = self.buildGraph(edges)
        return self.hasPath(graph, source, destination, set())
    
	# function to convert list of edges to adjacency list graph
    def buildGraph(self, edges):
        graph = defaultdict(list)
        for edge in edges:
            a, b = edge
            graph[a].append(b)
            graph[b].append(a)    
        return graph
    
    def hasPath(self, graph, src, dst, visited):
        if src == dst:
            return True
        if src in visited:
            return False
        visited.add(src)
        for neighbour in graph[src]:
            if self.hasPath(graph, neighbour, dst, visited) == True:
                return True
        return False
            
        
