
//intution: connect last node of left subtree to the right of the root
//ide: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//sol: https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=41

/////METHOD-1

// Time Complexity: O(N)
// Reason: We are doing a simple preorder traversal.
// Space Complexity: O(N)
// Reason: Worst case time complexity will be O(N) (in case of skewed tree).

//why static variable didnt work 
// Static variables are allocated memory only once during the runtime. I guess when multiple test cases are executed, the static variable doesn't start from 0 for each new test case and hence the index goes out of bound for the given preorder vector.
// To counter this we could use Global Variable. Whenever a new object of the class is declared, the value of the global variable will start with 0. Hence solving the purpose.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
        
    }
}

////METHOD -2 
// Time Complexity: O(N)
// Reason: The loop will execute for every node once.
// Space Complexity: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
      if (root == null) return;
      Stack <TreeNode> st=new Stack<>();
      st.push(root);
      while (!st.isEmpty()) {
        TreeNode cur = st.peek();
        st.pop();

        if (cur.right != null) {
          st.push(cur.right);
        }
        if (cur.left != null) {
          st.push(cur.left);
        }
        if (!st.isEmpty()) {
          cur.right = st.peek();
        }
        cur.left = null;

      }
    }
}

///METHOD-3
// Time Complexity: O(N)
// Reason: Time complexity will be the same as that of a morris traversal
// Space Complexity: O(1)
// Reason: We are not using any extra space.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
     TreeNode cur = root;
     while (cur!=null)
        {
            if(cur.left!=null)
            {
                TreeNode pre = cur.left;
                while(pre.right!=null)
                {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
