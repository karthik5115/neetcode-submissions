class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int [] par = new int [edges.length+1];
        int [] rank = new int [edges.length+1];
        for(int i=1;i<=edges.length;i++){
            par[i]=i;
            rank[i]=1;
        }
        for(int [] edge : edges){
            if(!union(edge[0],edge[1],par,rank)){
                    return edge;
            }
        }
        return new int[0];
    }
    public boolean union(int n1,int n2,int []par,int [] rank){
        int p1 = find(n1,par);
        int p2 = find(n2,par);
        if(p1==p2){
            return false;
        }
        if(rank[p1]>rank[p2]){
            par[p2]=p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1]=p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
    public int find(int n1,int[]par){
        int p = par[n1];
        while(p!=n1){
            par[n1]=par[par[n1]];
            n1=p;
            p=par[n1];
        }
        return p;
    }
}
