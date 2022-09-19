
class Solution {
    public int orangesRotting(int[][] grid) {
        class pair{
            int row;
            int col;
            pair(int row,int col){
                this.row=row;
                this.col=col;
            }
            
        }
        int fresh=0;
        Queue<pair> rotten=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){               
                   rotten.add(new pair(i,j));    
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
                
            }
        }
        
        if(fresh==0){
            return 0;
        }
        int [][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int minPassed=-1;
        while(rotten.size()>0){
            int size=rotten.size();
            minPassed++;
            while(size-->0){
                pair rem =rotten.remove();
                for(int i=0;i<dir.length;i++){
                    int rdash=rem.row+dir[i][0];
                    int cdash=rem.col+dir[i][1];
                    
                    if(rdash>=0 && cdash>= 0 && rdash<grid.length && cdash<grid[0].length                                   && grid[rdash][cdash]==1){

                    rotten.add(new pair(rdash,cdash));
                    grid[rdash][cdash]=0;
                    fresh--;
                    }
                }
            }     

        }
        
        if(fresh==0){
            return minPassed;
        }
        else{
            return -1;
        }
    }
}





// Time Complexity: O(2 * M * N) --> Each cell in the grid is visited maximum
//  * twice.
//  *
//  * Space Complexity: O(M * N) --> Queue Size
//  *
//  * M = Number of rows. N = Number of columns




// --> is not a new operator.

// It is just a conjunction of the operators -- and  >.

// You first compare, and then decrement the variable.

// That is,

// i --> 0

// becomes effectively

// i > 0; //Compare
// i--; //and decrement
//https://stackoverflow.com/questions/29429605/what-does-mean-in-java
