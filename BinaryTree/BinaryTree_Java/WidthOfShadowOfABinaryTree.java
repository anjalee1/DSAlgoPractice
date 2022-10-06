
public static void width(TreeNode root, int hl, int[] ans) {
        if (root == null)
            return;

        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);

        width(root.left, hl - 1, ans);
        width(root.right, hl + 1, ans);
    }

    public static int width(TreeNode root) {
        int[] ans = new int[2];
        width(root, 0, ans);
        return ans[1] - ans[0] + 1;
    }
