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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return rec(root,target)?null:root;
    }
    public boolean rec(TreeNode root,int target){
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null && root.val==target){
            return true;
        }
        boolean left = rec(root.left,target);
        boolean right = rec(root.right,target);
        if(left){
            root.left=null;
        }
        if(right){
            root.right=null;
        }
        if(root.left==null && root.right==null && root.val==target){
            return true;
        }
        return false;

    }
}