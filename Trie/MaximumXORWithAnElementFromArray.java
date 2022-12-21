//ide :https://leetcode.com/problems/longest-common-prefix/
//sol:https://www.youtube.com/watch?v=Q8LhG9Pi5KM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=9
//tc:qlogq+o(q*32+n*#2)+nlogn




class Node {
    Node links[] = new Node[2]; 
    
    public Node() {
    }
    boolean containsKey(int ind) {
        return (links[ind] != null); 
    }
    Node get(int ind) {
        return links[ind]; 
    }
    void put(int ind, Node node) {
        links[ind] = node; 
    }
};
class Trie {
    private static Node root; 

    //Initialize your data structure here

    Trie() {
        root = new Node(); 
    }


    //Inserts a word into the trie

    public static void insert(int num) {
        Node node = root;
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(!node.containsKey(bit)) {
                node.put(bit, new Node()); 
            }
            node = node.get(bit); 
        }
    }
    
    public int getMax(int num) {
        Node node = root; 
        int maxNum = 0; 
        for(int i = 31;i>=0;i--) {
            int bit = (num >> i) & 1; 
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get( 1 - bit); 
            }
            else {
                node = node.get(bit); 
            }
        }
        return maxNum; 
    }
};

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {

         Arrays.sort(nums);
         int m = queries.length; 
         int[][] offlineQueries = new int[m][3];   
         
         for(int i = 0;i<m;i++) {
             offlineQueries[i][0]=queries[i][0];
             offlineQueries[i][1]=queries[i][1];
             offlineQueries[i][2]=i;  
         }
         Arrays.sort(offlineQueries, (a, b) -> a[1] - b[1]);
         int ind = 0;
         int n = nums.length; 
         Trie trie = new Trie(); 
         int[] ans = new int[m]; 
         
         for(int i = 0;i<m;i++) {
             while(ind<n && nums[ind] <= offlineQueries[i][1]) {
                 trie.insert(nums[ind]); 
                 ind++; 
             }
             int queryInd = offlineQueries[i][2]; 
             if(ind!=0) ans[queryInd] =trie.getMax(offlineQueries[i][0]);
             else ans[queryInd]=-1; 
         }
         return ans; 
        
    }
}
