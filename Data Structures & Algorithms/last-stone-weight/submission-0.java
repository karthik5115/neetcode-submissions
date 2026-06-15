class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i:stones){
            q.offer(i);
        }
        while(q.size()>1){
            System.out.println(q);
            int x = q.poll();
            int y = q.poll();
            q.offer(Math.abs(x-y));
        }
        return q.poll();
        
    }
}
