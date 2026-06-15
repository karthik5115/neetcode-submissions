class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->(a[0]==b[0])?(a[1]-b[1]):a[0]-b[0]);
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            while(i<intervals.length && intervals[i][0]<=q){
                minheap.offer(new int[]{intervals[i][1]-intervals[i][0]+1,intervals[i][1]});
                i++;
            }
            while(!minheap.isEmpty() && minheap.peek()[1]<q){
                minheap.poll();
            }
            int x = minheap.isEmpty()?-1:minheap.peek()[0];
            res.put(q,x);
    }
     int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        return result;
    }
}
