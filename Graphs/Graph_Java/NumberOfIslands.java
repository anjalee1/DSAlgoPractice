
class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row =row;
        this.col=col;
        
    }
}


class Solution {
    
    private void bfs(int row ,int col, int [][] vis,char[][] grid){
        
        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int m =grid.length;
        int n =grid[0].length;
        
        while(!q.isEmpty()){
            int r =q.peek().row;
            int c =q.peek().col;
            q.remove();
            
            
            for(int delRow =-1 ;delRow<=1;delRow++){
               for(int delCol=-1 ;delCol<=1;delCol++){
                   
                   if((delRow==-1 && delCol==-1) || (delRow==-1 && delCol==1) || 
                      (delRow==1 && delCol==-1)  || (delRow==1  && delCol==1)){
                        continue;
                    }

                   int nRow= r+delRow;
                   int nCol= c+delCol;
                   
                   if(nRow>=0 && nRow<m && nCol>=0 && nCol<n
                     && grid[nRow][nCol]=='1' &&  vis[nRow][nCol]==0){
                       vis[nRow ][nCol]=1;
                       q.add(new Pair(nRow,nCol));
                   }   
                }
             }
        }
    }
    
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] vis=new int[m][n];
        int cnt =0;
        
        for(int row =0 ;row<m;row++){
            for(int col=0 ;col<n;col++){
                
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }   
        }
        
        return cnt;
    }
}

//tc: n^2
//sc: n^2

//ide:https://leetcode.com/problems/number-of-islands/
//sol: https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
