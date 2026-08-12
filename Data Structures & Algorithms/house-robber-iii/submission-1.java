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
    public int rob(TreeNode root) {
        HashMap<String,Integer> map = new HashMap<>();
        return Math.max(recursion(root,true,map),recursion(root,false,map));
    }
    public int recursion(TreeNode root,boolean rob,HashMap<String,Integer> map){
        if(root==null){
            return 0;
        }
        String key = root.hashCode()+ ":"+rob;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(!rob){
            int leftrob = recursion(root.left,true,map);
            int rightrob = recursion(root.right,true,map);
            return leftrob+rightrob;
        }

        int leftrob = recursion(root.left,false,map);
        int rightrob = recursion(root.right,false,map);

        int leftNrob = recursion(root.left,true,map);
            int rightNrob = recursion(root.right,true,map);
        
        int asd=  Math.max(root.val+leftrob+rightrob, leftNrob+rightNrob);
        map.put(key,asd);
        return asd;
       

    }
}