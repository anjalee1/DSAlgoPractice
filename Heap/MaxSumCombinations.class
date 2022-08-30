import java.util.*;

class Pair implements Comparable<Pair> {
      int data;
      int i;
      int j;

      Pair(int data, int i, int j){
         this.data = data;
         this.i = i;
         this.j = j;
      }

      @Override
      public int compareTo(Pair o){
         if (this.data <o.data){
             return 1;
             
         }
         else if (this.data >o.data){
             return -1;
             
         }
         else{
             return 0;
         }
      }
   }
   
class PairSet {

    int i;
    int j;
    PairSet(int i, int j){
        
         this.i = i;
         this.j= j;
      }
      
    @Override public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof PairSet)) {
            return false;
        }
        PairSet obj = (PairSet)o;
        return (i == obj.i && j == obj.j);
    }

    @Override public int hashCode() {
        return Objects.hash(i, j);
    }

}

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A);
        Collections.sort(B);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<PairSet> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n=A.size();
        
        pq.add(new Pair(A.get(n-1)+B.get(n-1),n-1,n-1));
        set.add(new PairSet(n-1, n-1));
        while(C>0){
            Pair top=pq.remove();;
            int val=top.data;
            int i=top.i;
            int j=top.j;
            ans.add(val);
            if(set.contains(new PairSet(i-1,j))==false && i>0){
                pq.add(new Pair((A.get(i-1)+B.get(j)),i-1,j));
                set.add(new PairSet(i-1,j));
                
            }
            
            if(set.contains(new PairSet(i,j-1))==false && j>0){
                pq.add(new Pair((A.get(i)+B.get(j-1)),i,j-1));
                set.add(new PairSet(i,j-1));
                
            }
            C=C-1;
        }
        return ans;
        
    }
}  
    
