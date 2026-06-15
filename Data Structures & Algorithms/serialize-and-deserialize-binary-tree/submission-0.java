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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfsSer(root,res);
        System.out.println(String.join(",",res));
        return String.join(",",res);
        
    }
    public void dfsSer(TreeNode root,ArrayList<String> res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(Integer.toString(root.val));
        dfsSer(root.left,res);
        dfsSer(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String dat) {
        String[] data = dat.split(",");
        int ind[]=new int[1];
        return dfsds(data,ind);
        
    }
    public TreeNode dfsds(String[] data,int[] ind){
        if(data[ind[0]].equals("N")){
            ind[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[ind[0]]));
        System.out.println(root.val+" "+ind[0]);
        ind[0]++;
        root.left = dfsds(data,ind);
        root.right = dfsds(data,ind);
        return root;
    }
}
