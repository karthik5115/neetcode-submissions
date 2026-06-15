class Solution {
    HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {
        
        for(int [] edge:edges){
            ArrayList<Integer> nei1 = mp.getOrDefault(edge[0],new ArrayList<>());
            ArrayList<Integer> nei2 = mp.getOrDefault(edge[1],new ArrayList<>());
            nei1.add(edge[1]);
            nei2.add(edge[0]);
            mp.put(edge[0],nei1);
            mp.put(edge[1],nei2);
        }
        HashSet<Integer> visited = new HashSet<>();
        return dfs(0,visited,-1) && visited.size()==n;
        
    }
    public boolean dfs(int node,HashSet<Integer> visited,int prev){
        if(!visited.contains(node)){
            visited.add(node);
            boolean ans = true;
            for(Integer neig:mp.getOrDefault(node,new ArrayList<>())){
                if(neig!=prev){
                    ans = ans && dfs(neig,visited,node);
                }
            }
            return ans;
        }
            return false;
        
    }
}
