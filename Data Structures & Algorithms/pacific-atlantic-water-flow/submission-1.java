class Solution {
    public void  dfs(int[][] height,int r,int c,HashSet<List<Integer>> visited,int prev_height){
        List<Integer> temp= new ArrayList<>();
        temp.add(r);
        temp.add(c);
        if(r<0 || c<0 || r>=height.length || c>=height[0].length || visited.contains(temp) || height[r][c]<prev_height){
            return;
        }
        visited.add(temp);
        dfs(height,r+1,c,visited,height[r][c]);
        dfs(height,r,c+1,visited,height[r][c]);
        dfs(height,r-1,c,visited,height[r][c]);
        dfs(height,r,c-1,visited,height[r][c]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    HashSet<List<Integer>> pacific= new HashSet<>();
    HashSet<List<Integer>> atlantic= new HashSet<>();
        for(int c=0;c<heights[0].length;c++){
            dfs(heights,0,c,pacific,0);
            dfs(heights,heights.length-1,c,atlantic,0);
        }
        for(int r=0;r<heights.length;r++){
            dfs(heights,r,0,pacific,0);
            dfs(heights,r,heights[0].length-1,atlantic,0);
        }
        List<List<Integer>> res= new ArrayList<>();
        for(List<Integer> x:pacific){
            if(atlantic.contains(x)){
                res.add(x);
            }
        }
        return res;
    }
}
