class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n-k+1];
        for(int i =0;i<k;i++){
            if(q.isEmpty()){
                q.offerFirst(i);
            }
            else{
                if(nums[q.peekFirst()]>nums[i]){
                    q.offerFirst(i);
                }
                else{
                    while(!q.isEmpty() && nums[q.peekFirst()]<=nums[i]){
                        q.pollFirst();
                    }
                    q.offerFirst(i);
                }
            }
        }
        ans[0]=nums[q.peekLast()];
        int x=1;
        for(int i=k;i<n;i++){
            int min_valid_index = i-k+1;
            if(q.peekLast()<min_valid_index){
                q.pollLast();
            }
             if(q.isEmpty()){
                q.offerFirst(i);
            }
            else{
            if(nums[q.peekFirst()]>nums[i]){
                    q.offerFirst(i);
                }
                else{
                    while(!q.isEmpty() && nums[q.peekFirst()]<=nums[i]){
                        q.pollFirst();
                    }
                    q.offerFirst(i);
                }
            }
            ans[x++]=nums[q.peekLast()];


        }
        return ans;
        
    }
}