
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        paths = []
        if not graph or len(graph) == 0:
            return paths
        
        s = 0
        d = len(graph)-1
        
        temp_path = [0]
        return self.traversePath(graph,s,d,temp_path,paths)

    def traversePath(self,graph,s,d,temp_path,paths):

        if s == d:
            paths.append(temp_path)
        else:
            for node in graph[s]:
                copy_path = temp_path.copy()
                copy_path.append(node)
                self.traversePath(graph,node,d,copy_path,paths)

        return paths
        
        
                
