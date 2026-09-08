class Solution {
    class UnionFind{
          int[] rank;
          int [] par;
          UnionFind(int n){
            this.rank = new int[n];
            Arrays.fill(this.rank,1);
            this.par = new int[n];
            for(int i=0;i<n;i++){
                this.par[i]=i;
            }
          }
          public int maxRank(){
            int max = Arrays.stream(rank).max().getAsInt();
            return max;
          }
          public int find(int v1){
            if(v1==par[v1]){
                return par[v1];
            }
            par[v1] = find(par[v1]);
            return par[v1];
          }
          public boolean union(int v1,int v2){
            int pv1 = find(v1);
            int pv2 = find(v2);
            if(pv1==pv2){
                return false;
            }
            if(rank[pv1]>rank[pv2]){
                par[pv2]=pv1;
                rank[pv1]+=rank[pv2];
            }
            else{
                par[pv1]=pv2;
                rank[pv2]+=rank[pv1];
            }
            return true;
          }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges){
        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new int[] { edges[i][0], edges[i][1], edges[i][2], i });
        }
        edgeList.sort((a,b)->a[2]-b[2]);
        int originalmst=0;
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edgeList){
            if(uf.union(edge[0],edge[1])){
                originalmst+=edge[2];
            }
        }
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for(int[] exc:edgeList){
        int mst=0;
        uf = new UnionFind(n);
        for(int[] edge:edgeList){
            if(edge[3]!=exc[3] && uf.union(edge[0],edge[1])){
                mst+=edge[2];
            }
        }
        if( uf.maxRank()!=n || mst>originalmst){
            critical.add(exc[3]);
            continue;
        }
        int mst1=exc[2];
        UnionFind uf1 = new UnionFind(n);
        uf1.union(exc[0],exc[1]);
        for(int[] edge:edgeList){
            if(uf1.union(edge[0],edge[1])){
                mst1+=edge[2];
            }
        }
        if( mst1==originalmst){
            pseudo.add(exc[3]);
        }
        }
return Arrays.asList(critical,pseudo);

    }
}