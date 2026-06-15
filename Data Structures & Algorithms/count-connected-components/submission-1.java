class Solution {
    HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
 
    
        
        for(int [] edge:edges){
            ArrayList<Integer> nei1 = mp.getOrDefault(edge[0],new ArrayList<>());
            ArrayList<Integer> nei2 = mp.getOrDefault(edge[1],new ArrayList<>());
            nei1.add(edge[1]);
            nei2.add(edge[0]);
            mp.put(edge[0],nei1);
            mp.put(edge[1],nei2);
        }
        HashSet<Integer> visited = new HashSet<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                c++;
                dfs(i,visited);
            }
        }
        return  c;
        
    }
   public void dfs(int node, HashSet<Integer> visited) {
    if (visited.contains(node)) return;

    visited.add(node);
    for (int neig : mp.getOrDefault(node, new ArrayList<>())) {
        dfs(neig, visited);
    }
}


}
