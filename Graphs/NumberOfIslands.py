class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        rows=len(grid)
        cols=len(grid[0])
        count=0
        for row in range(rows):
            for col in range(cols):
                if grid[row][col]=='1':
                    self.getcountofIsland(grid,row,col)
                    count=count+1
        return count
    
    def getcountofIsland(self,grid,row,col):
        if row<0 or col<0 or row>=len(grid) or col>=len(grid[0]) or grid[row][col] != '1':
             return
        grid[row][col]='-'
        self.getcountofIsland(grid,row-1,col)
        self.getcountofIsland(grid,row+1,col)
        self.getcountofIsland(grid,row,col-1)
        self.getcountofIsland(grid,row,col+1)
        

                    
        
