class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> mp;
    public int findTargetSumWays(int[] nums, int target) {
        mp = new HashMap<>();
        return rec(nums,target,0,0);
    }
    public int rec(int[] nums, int target,int i,int tsum){
        if(i==nums.length){
            if(tsum==target){
                return 1;
            }
            return 0;
        }
        if(mp.containsKey(i)){
            if(mp.get(i).containsKey(tsum)){
                return mp.get(i).get(tsum);
            }
        }
        
    int x =  rec(nums,target,i+1,tsum-nums[i]) + rec(nums,target,i+1,tsum+nums[i]);
    HashMap<Integer,Integer> temp = new HashMap<>();
    temp.put(tsum,x);
    mp.put(i,temp);
    return x;
        }
}
