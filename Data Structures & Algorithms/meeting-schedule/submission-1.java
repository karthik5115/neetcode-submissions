/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)-> a.start-b.start);
        int prevEnd=-1;
        for(Interval i:intervals){
            int start = i.start;
            int end = i.end;
            if(start>=prevEnd){
                prevEnd=end;
            }
            else{
                return false;
            }
            
        }
        return true;
    }
}
