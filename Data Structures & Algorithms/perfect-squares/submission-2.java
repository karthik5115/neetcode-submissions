class Solution {
    HashMap<Integer,Integer> map;
    public int numSquares(int n) {
        int num = (int)Math.sqrt(n);
        ArrayList<Integer> arr = new ArrayList<>();
         map = new HashMap<>();
        while(num>0){
            arr.add(num*num);
            num--;
        }
        return rec(arr,n); 
    }
    public int rec(ArrayList<Integer> nums,int target){
     if(target==0){
           return 0;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        int x=Integer.MAX_VALUE;
        for(int j=0;j<nums.size();j++){
           if(target-nums.get(j)>=0){
           int res = rec(nums,target-nums.get(j));
           if(res!=Integer.MAX_VALUE){
                x = Math.min(x, 1+res);
           } 
           }
            }
    map.put(target,x);
    return map.get(target);
         
    }
}