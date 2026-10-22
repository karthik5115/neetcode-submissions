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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> x = new ArrayList<>();
        tras(x,root);
        return x;
    }
    public void tras(List<Integer> x,TreeNode root){
        if(root==null){
            return;
        }
        tras(x,root.left);
        x.add(root.val);
        tras(x,root.right);
    }
}