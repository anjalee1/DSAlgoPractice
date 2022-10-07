
import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/

public class Solution {
    public static class verticalPair {
        BinaryTreeNode node = null;
        int hl = 0; // horizontal Level

        verticalPair(BinaryTreeNode node, int hl) {
            this.node = node;
            this.hl = hl;
        }
    }

    // ans = {minHl,maxHL}
    public static void width(BinaryTreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
         ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
		LinkedList<verticalPair> que = new LinkedList<>();
        int[] minMax = new int[2];
        width(root, 0, minMax);
        int length = minMax[1] - minMax[0] + 1;
       
        for (int i = 0; i < length; i++)
            ans.add(null);

        que.addLast(new verticalPair(root, -minMax[0]));

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                verticalPair rp = que.removeFirst();

                if (ans.get(rp.hl) == null)
                    ans.set(rp.hl, rp.node.val);

                if (rp.node.left != null)
                    que.addLast(new verticalPair(rp.node.left, rp.hl - 1));

                if (rp.node.right != null)
                    que.addLast(new verticalPair(rp.node.right, rp.hl + 1));
            }
        }

        return ans;
	}
}

// Time Complexity: O(N)
// Space Complexity: O(N)

//ide: https://www.codingninjas.com/codestudio/problems/799401?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//sol: https://www.youtube.com/watch?v=DhgD8dyp8RM&t=976s
