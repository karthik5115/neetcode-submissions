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
    public boolean isValidBST(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0]=true;
        int[] x = rec(root,ans);
        return ans[0];
        
    }
        public int[] rec(TreeNode root,boolean[]ans){
            if(root==null){
                return new int[]{1001,-1001};
            }
            int mxleft[] = rec(root.left,ans);
            int mnright[] = rec(root.right,ans);
            //System.out.println(root.val+" "+mxleft[1]+" "+mnright[0]);
             if(mxleft[1]>=root.val || mnright[0]<=root.val){
                ans[0]=false;
             }
            return new int[] {Math.min(root.val,Math.min(mxleft[0],mnright[0])),Math.max(root.val,Math.max(mxleft[1],mnright[1]))};

        }
}
