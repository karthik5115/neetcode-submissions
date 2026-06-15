class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         HashSet<Integer> visited = new HashSet<>();
        
        rec(nums,ans,temp,visited);
        return ans;
        
    }
    public void rec(int[]nums,List<List<Integer>> ans,List<Integer>temp,HashSet<Integer> visited){
        if(temp.size()==nums.length){
            List<Integer> temp1 = new ArrayList<>(temp);
            ans.add(temp1);
            return;
        }
        for(int i=0;i<nums.length;i++){
        if(!visited.contains(nums[i])){
            temp.add(nums[i]);
            visited.add(nums[i]);
        rec(nums,ans,temp,visited);
        temp.remove(temp.size()-1);
            visited.remove(nums[i]);
        }
        }

    }
}
