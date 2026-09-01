class Solution {
    class pair{
        int i;
        int j;
        int diff;
        pair(int i,int j,int diff){
            this.i=i;
            this.j=j;
            this.diff=diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int [][]visited = new int[heights.length][heights[0].length];
        visited[0][0]=1;
        Queue<pair> q = new PriorityQueue<>((a,b)->a.diff-b.diff);
        q.offer(new pair(0,0,0));
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            pair node = q.poll();
            visited[node.i][node.j]=1;
            if(node.i==heights.length-1 && node.j==heights[0].length-1){
                return node.diff;
            }
            int dirs[] = {1,-1};
            for(int dir:dirs){
                if(node.i+dir>=0 && node.i+dir<heights.length && visited[node.i+dir][node.j]==0){
                    
                    int diff = Math.abs(heights[node.i][node.j]-heights[node.i+dir][node.j]);
                    q.offer(new pair(node.i+dir,node.j,Math.max(diff,node.diff)));
                }
                if(node.j+dir>=0 && node.j+dir<heights[0].length && visited[node.i][node.j+dir]==0){
                    int diff = Math.abs(heights[node.i][node.j]-heights[node.i][node.j+dir]);
                  
                    q.offer(new pair(node.i,node.j+dir,Math.max(diff,node.diff)));
                }
            }
        }
        return ans;   
    }
}