class Solution {
    public int mySqrt(int x) {
        int low = 0,high=46340;
        while(low<=high){
            int mid= low+((high-low)/2)/2;
            if((mid*mid)>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return high;

    }
}