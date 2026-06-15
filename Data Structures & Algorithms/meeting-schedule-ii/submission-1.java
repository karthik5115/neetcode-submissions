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
    public int minMeetingRooms(List<Interval> intervals) {
    Queue<Integer> q = new PriorityQueue<>();
    Collections.sort(intervals,(a,b)->a.start-b.start);
    q.add(-1);
    int ans = 0;
    for(Interval i :intervals){
        if(q.peek()<=i.start){
            q.poll();
            q.offer(i.end);
        }
        else{
            q.offer(i.end);
        }
        ans = Math.max(ans,q.size());
    }
return ans;
    }
}
