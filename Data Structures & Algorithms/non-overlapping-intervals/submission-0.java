class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res=0;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int prevEnd = intervals[0][1];
        for(int [] i:intervals){
            int start=i[0];
            int end=i[1];
            if(start>=prevEnd){
                prevEnd=end;
            }
            else{
                res++;
                prevEnd=Math.min(prevEnd,end);
            }
        }
        return res-1;
    }
}
