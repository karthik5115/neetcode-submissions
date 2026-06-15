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
    public boolean rec(TreeNode root, TreeNode p, TreeNode q,TreeNode[]ans){
        if(root==null){
            return false;
        }
       boolean xleft = rec(root.left,p,q,ans);
       boolean xright = rec(root.right,p,q,ans);
        System.out.println(root.val+" "+xleft+" "+xright);
       if((xleft || xright) && (root.val==p.val || root.val==q.val)){
        ans[0]=root;
        return true;
       }
       else if(root.val==p.val || root.val==q.val){
        return true;
       }
       else if(xleft && xright){
        ans[0]=root;
        return true;
       }
       else if(xleft || xright){
        return true;
       }
       return false;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        boolean x = rec(root,p,q,ans);
        return ans[0];
    }
}
