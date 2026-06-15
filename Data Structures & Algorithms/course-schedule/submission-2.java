class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,ArrayList<Integer>> prerq = new HashMap<>();
        for(int []i:prerequisites){
            ArrayList<Integer> temp = prerq.getOrDefault(i[0],new ArrayList<>());
            temp.add(i[1]);
            prerq.put(i[0],temp);
        }
         HashSet<Integer> waiting = new HashSet<>();
         HashSet<Integer> completed = new HashSet<>();
         boolean ans=true;
        for(int i=0;i<numCourses;i++){
           if(!completed.contains(i)){
            ans = ans && dfs(i,prerq,completed,waiting);
            if(!ans){
                return false;
            }
           }

        }
                    return ans;
        
    }
    public boolean dfs(int i,HashMap<Integer,ArrayList<Integer>>prerq,HashSet<Integer>completed,HashSet<Integer>waiting){
        boolean ans=true;
        waiting.add(i);
        for(Integer pre:prerq.getOrDefault(i,new ArrayList<>())){
            if(waiting.contains(pre)){
                return false;
            }
            if(completed.contains(pre)){
                continue;
            }
            
            ans = ans && dfs(pre,prerq,completed,waiting);
            if(!ans){
                return false;
            }
             
        }
        
        
            waiting.remove(i);
            completed.add(i);
        
        return ans;
    }
}
