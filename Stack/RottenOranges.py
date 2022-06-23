
https://leetcode.com/problems/rotting-oranges/submissions/
https://leetcode.com/problems/rotting-oranges/discuss/563686/Python-Clean-and-Well-Explained-(faster-than-greater-90)
https://www.youtube.com/watch?v=Dq3dGS_0Z6o
  
from collections import deque
class Solution:
        def orangesRotting(self, grid: List[List[int]]) -> int:
            fresh=0
            rotten=deque()
            for i in range(len(grid)):
                for j in range(len(grid[0])):
                    if grid[i][j]==2:
                        rotten.append((i,j))
                    elif grid[i][j]==1:
                        fresh=fresh+1
            if fresh==0:
                return 0
            minutespassed=0
            while rotten and fresh>0:
                minutespassed=minutespassed+1
                for ro in range(len(rotten)):
                    x,y=rotten.popleft()
                    for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                        xx,yy=x+dx,y+dy
                        if xx<0 or xx==len(grid) or yy<0 or yy==len(grid[0])or grid[xx][yy]==2                         or grid[xx][yy]==0:
                            continue
                        fresh=fresh-1
                        grid[xx][yy]=2
                        rotten.append((xx,yy))
            return minutespassed if fresh ==0 else -1 

                
                    
                    
