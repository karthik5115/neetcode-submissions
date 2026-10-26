class Solution {
    public int[] getOrder(int[][] tasks) {
        Queue<Integer[]> available = new PriorityQueue<>((a,b)->(a[0]==b[0])? a[1]-b[1] : a[0]-b[0]);
        Queue<Integer[]> pending = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n = tasks.length;
        int time=0,ind=0;
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            pending.offer(new Integer[] {tasks[i][0],tasks[i][1],i});
        }

        while(!pending.isEmpty() || !available.isEmpty()){
            while(!pending.isEmpty() && pending.peek()[0]<=time){
                Integer [] x = pending.poll();
                available.offer(new Integer[]{x[1],x[2]});
            }
            if(available.isEmpty()){
                time = pending.peek()[0];
                continue;
            }
            Integer [] task = available.poll();
            time += task[0];
            res[ind++]=task[1];
        }
        return res;

    }
}