class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int []row_order= topo_sort(k,rowConditions);
        int []col_order = topo_sort(k,colConditions);
        if(row_order.length==0 || col_order.length==0){
            return new int[0][0];
        }
        HashMap<Integer,Integer> val_rind = new HashMap<>();
         HashMap<Integer,Integer> val_cind = new HashMap<>();
        for(int i=0;i<row_order.length;i++){
            val_rind.put(row_order[i],i);
        }
        for(int i=0;i<col_order.length;i++){
            val_cind.put(col_order[i],i);
        }
        int res[][] = new int[k][k];
        for(int i=1;i<=k;i++){
            int r = val_rind.get(i);
            int c = val_cind.get(i);
            res[r][c]=i;
        } 
        return res;
    }

    public int[] topo_sort(int k,int[][]conditions){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=k;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] con:conditions){
            adj.get(con[0]).add(con[1]);
        }
        ArrayList<Integer> order = new ArrayList<>();
        HashSet<Integer> path = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i=1;i<=k;i++){
            if(!visited.contains(i)){
            if(!dfs(i,order,path,visited,adj)){
                return new int[0];
            }
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(Integer::intValue).toArray();
        
    }
    public boolean dfs(int src,ArrayList<Integer> order,HashSet<Integer> path,HashSet<Integer> visited,List<List<Integer>> adj){
        if(path.contains(src)){
            return false;
        }
        if(visited.contains(src)){
            return true;
        }
        path.add(src);
        visited.add(src);
        for(Integer nei:adj.get(src)){
                if(!dfs(nei,order,path,visited,adj)){
                    return false;
                }
        }
        path.remove(src);
        order.add(src);
        return true;

    }
}