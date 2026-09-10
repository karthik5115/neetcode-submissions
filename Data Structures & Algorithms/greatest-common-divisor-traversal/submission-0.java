class Solution {
    class unionFind{
        int par[];
        int rank[];
        int n;
        unionFind(int n){
            this.n=n;
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
                rank[i]=1;
            }
        }
        public int find(int x){
            if(par[x]!=x){
                par[x]=find(par[x]);
            }
            return par[x];
        }
        public boolean union(int x,int y){
            int px = find(x), py=find(y);
            if(px==py){
                return false;
            }
            n--;
            if(rank[px]>rank[py]){
                par[py]=px;
                rank[px]+=rank[py];
            }
            else{
                par[px]=py;
                rank[py]+=rank[px];
            }
            return true;
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        unionFind uf = new unionFind(nums.length);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
                int fac = 2;
                int num = nums[i];
                while(fac*fac<=num){
                    if(num%fac==0){
                        if(map.containsKey(fac)){
                            uf.union(map.get(fac),i);
                        }
                        else{
                            map.put(fac,i);
                        }
                    while(num%fac==0){
                        num/=fac;
                    }
                    }
                    fac++;  
                }
                if(num>1){
                   if(map.containsKey(num)){
                            uf.union(map.get(num),i);
                        }
                        else{
                            map.put(num,i);
                        }
                }
        }
        System.out.println(uf.n);
        return uf.n==1;
        
    }
}