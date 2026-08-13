class Solution {
    public int calc(int[] weights,int weight){
        int dayweight=0,days=0;
        for(int w:weights){
            dayweight+=w;
            if(dayweight>weight){
                days++;
                dayweight=0;
                dayweight+=w;
            }
            
        }
        
        return dayweight==0?days:days+1;

    }
    public int shipWithinDays(int[] weights, int days) {
        int low=1,high=0;
        for(int w:weights){
            low = Math.max(w,low);
            high+=w;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println(mid+" "+calc(weights,mid)+" " +days);
            if(calc(weights,mid)>days){
                
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}