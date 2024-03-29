//ide:https://www.interviewbit.com/problems/distinct-numbers-in-window/
//sol: https://www.youtube.com/watch?v=x8O9XocEioI

//tc:o(n)
//sc: o(n)


public class Solution {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n-B+1];
        HashMap<Integer,Integer> mapping = new HashMap <Integer, Integer>();
        for (int i=0; i<B; i++){
            if (mapping.containsKey(A[i]))
                mapping.put(A[i], mapping.get(A[i])+1);
            else
                mapping.put(A[i], 1);
        }
        ans[0] = mapping.size();
        //System.out.println("jj" + (n-B));
        for(int i=1; i<=n-B; i++){
            int prev= i-1;
            //System.out.println(i+"  " + A[prev]);
            
            if (mapping.get(A[prev]) == 1)
                mapping.remove(A[prev]);
            else
                mapping.put(A[prev], mapping.get(A[prev]) - 1);
                
            int next = i+B-1;
            if (mapping.containsKey(A[next]))
                mapping.put(A[next], mapping.get(A[next])+1);
            else
                mapping.put(A[next], 1);
            
            ans[i] = mapping.size();
        }
        return ans;
    }
}

