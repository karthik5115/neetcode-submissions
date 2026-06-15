class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();

        rec(0,nums,ans,temp);
        return ans;
        
    }
    public void rec(int ind,int[]nums,List<List<Integer>> ans,List<Integer>temp){
        if(ind>=nums.length){
           List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
            return;
        }
        temp.add(nums[ind]);
        rec(ind+1,nums,ans,temp);
        temp.remove(Integer.valueOf(nums[ind]));
        rec(ind+1,nums,ans,temp);

    }
}
