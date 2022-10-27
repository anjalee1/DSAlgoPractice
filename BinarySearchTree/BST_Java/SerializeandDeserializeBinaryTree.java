// string builder https://www.geeksforgeeks.org/stringbuilder-class-in-java-with-examples/
//any traversal can be used => https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

//sol: https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=43
//https://www.youtube.com/watch?v=T2-dVDWLQtE&t=914s

//Time Complexity: O(N)

//Space Complexity: O(N)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
        
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) {
       
        String [] arr =data.split(",");
        return deserializeHelper(arr);
    }
    
    private TreeNode deserializeHelper( String [] arr){
        if(idx>= arr.length || arr[idx].equals("null")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left=deserializeHelper(arr);
        node.right=deserializeHelper(arr);
        
        return node;
    }
        
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

