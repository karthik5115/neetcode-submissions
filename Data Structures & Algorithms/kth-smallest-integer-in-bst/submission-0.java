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
    public int kthSmallest(TreeNode root, int k) {
        int cnt[]=new int[1];
        int ans[]=new int[1];
        rec(root,k,ans,cnt);
        return ans[0];
        
    }
    public void rec(TreeNode root,int k,int [] ans,int[] cnt){
        if (root ==null){
            return;
        }
        rec(root.left,k,ans,cnt);
        cnt[0]++;
        if(cnt[0]==k){
            ans[0]=root.val;
            return;
        }
        rec(root.right,k,ans,cnt);
    }
}
