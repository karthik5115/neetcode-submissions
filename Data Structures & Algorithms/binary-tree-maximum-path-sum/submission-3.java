class Solution {

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        rec(root, ans);
        return ans[0];
    }

    public int rec(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }

        int left_max = Math.max(0, rec(root.left, ans));   // FIX
        int right_max = Math.max(0, rec(root.right, ans)); // FIX

        int x = root.val + left_max + right_max; // path through root
        ans[0] = Math.max(ans[0], x);             // update global max

        return root.val + Math.max(left_max, right_max); // path going up
    }
}
