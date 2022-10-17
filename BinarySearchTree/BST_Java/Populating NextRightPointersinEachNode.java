//sol:https://www.youtube.com/watch?v=3MRPQFUpoA0
//https://leetcode.com/submissions/detail/757937604/
//ide: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

//PERFECT BINARY TREE: https://www.programiz.com/dsa/perfect-binary-tree


//TC: O(N)
//SC:O(N)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root==null) return null;
        
        Node start=root;
        Node curr=root;
        
        while(curr.left!=null){
            
            curr.left.next=curr.right;
            if(curr.next!=null){
                curr.right.next=curr.next.left;
                curr=curr.next;
                
            }
            
            else{
                curr.next=null;
                curr = start.left;
                start=curr;
            }
        }
        
        return root;
        
    }
}

