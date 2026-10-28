class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int[] trip:trips){
            while(!q.isEmpty() && q.peek()[1]<=trip[1]){
                int [] x = q.poll();
                capacity += x[0];
            }
            if(capacity>=trip[0]){
                capacity-=trip[0];
                q.offer(new int[] {trip[0],trip[2]});
            }
            else{
                return false;
            }
        }
        return true; 
    }
}