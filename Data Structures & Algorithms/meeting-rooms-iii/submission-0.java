class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int [] roomBookingsCount = new int[n];
        PriorityQueue<long[]>availableRooms = new PriorityQueue<>((a,b)->(a[0]==b[0])?Long.compare(a[1],b[1]):Long.compare(a[0],b[0]));   // long[] availableTime, roomIndex
        for(int i=0;i<n;i++){
            availableRooms.offer(new long[]{0,i});
        }
        for(int [] meeting:meetings){
            int start = meeting[0],end=meeting[1];
            while(availableRooms.size()>0 && availableRooms.peek()[0]<start){
                long []availableRoom = availableRooms.poll();
                availableRooms.offer(new long[]{start,availableRoom[1]});  // update end time with start. then queue will sort next min room index for that availale room.
            }
            long []availableRoom = availableRooms.poll();
            long endTime = availableRoom[0]+(end-start);
            availableRooms.offer(new long[]{endTime,availableRoom[1]});
            roomBookingsCount[(int)availableRoom[1]]++;  
        }
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (roomBookingsCount[i] > roomBookingsCount[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
        
    }
}