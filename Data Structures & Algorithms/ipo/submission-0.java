class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Integer> qc = new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        Queue<Integer> qp = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int i=0;i<capital.length;i++){
            qc.offer(i);
        }
        for(int i=0;i<k;i++){
            while(!qc.isEmpty() && capital[qc.peek()]<=w){
                qp.offer(profits[qc.poll()]);
            }
            if(qp.isEmpty()){
                break;
            }
            w+=qp.poll();
        }
        return w;
    }
}