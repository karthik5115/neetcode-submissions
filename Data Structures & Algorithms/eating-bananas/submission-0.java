class Solution {
    public int count_hours(int mid,int []piles){
       
        int hrs=0;
        for(int i:piles){
            
            hrs+= Math.ceil((double)i/mid);
           // System.out.println(i+" f"+hrs);
        }
       //  System.out.println(mid+" "+hrs);
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high=-1;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        int ans=high;
        while(low<=high){
            int mid = low +((high-low)/2);
            if(count_hours(mid,piles)<=h){
                high=mid-1;
                ans = Math.min(mid,ans);
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}
