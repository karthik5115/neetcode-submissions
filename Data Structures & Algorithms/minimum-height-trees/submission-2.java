class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves = new LinkedList<>();
        Map<Integer,Integer> degree = new HashMap<>();
        for(int i=0;i<n;i++){
            if(adj.get(i).size()==1){
                leaves.offer(i);
            }
            degree.put(i,adj.get(i).size());
        }
        while(!leaves.isEmpty()){
            int len = leaves.size();
            if(n<=2){
                return new ArrayList<>(leaves);
            }
            for(int i=0;i<len;i++){
                int leave = leaves.poll();
                n--;
                for(int neigh:adj.get(leave)){
                degree.put(neigh,degree.get(neigh)-1);
                if(degree.get(neigh)==1){
                    leaves.add(neigh);
                }
                }

            }
        }
        List<Integer> x = new ArrayList<>();
        x.add(0);
        return x;
        
    }
}