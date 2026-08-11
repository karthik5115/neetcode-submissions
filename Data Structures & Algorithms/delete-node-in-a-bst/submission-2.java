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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode x = root,par=null;
        while(x!=null && x.val!=key){
            if(key>x.val){
                par=x;
                x=x.right;
            }
            else{
                par=x;
                x=x.left;
            }
        }
        if(x==null){
            return root;
        }

        if(x.left!=null && x.right!=null){
            TreeNode pred_parent = x;
            TreeNode pred = x.left;
            while(pred.right!=null){
                pred_parent=pred;
                pred = pred.right;
            }
            x.val=pred.val;
            par = pred_parent;
            x = pred;
        }
        TreeNode child = x.left==null?x.right:x.left;
        if(par==null){
            return child;
        }
        if(par.left==x){
            par.left=child;
        }
        else{
            par.right=child;
        }
        return root;

        

    }
}